package com.yuan.tool.collection;

import com.yuan.utils.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: TestHashMap
 * Author:   yhl
 * Date:     2019/12/15 19:44
 * Description: ${DESCRIPTION}
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMapOwn hashMapOwn = new HashMapOwn();
        hashMapOwn.put("a","22");
        hashMapOwn.put("b","22");
        hashMapOwn.put("c","22");
        hashMapOwn.put("c","ccc");
        hashMapOwn.put(15,"ccc");
        hashMapOwn.put(31,"ccc");
        hashMapOwn.put(47,"ccc");
        hashMapOwn.put(63,"ccc");
        hashMapOwn.put(79,"ccc");
        System.out.println(hashMapOwn.toString());
        Object o = hashMapOwn.get(47);
        System.out.println(o.toString());
        hashMapOwn.remove(47);
        System.out.println(hashMapOwn.toString());
    }
    @Test
    public void test(){
        HashMapOwn hashMapOwn = new HashMapOwn();
        for(int i = 0;i<100;i++){
            System.out.println("i:"+i+"---"+hashMapOwn.myHashValue(i,16));//15.31.47
        }
    }
}
class HashMapOwn{
    private Node2[] table;
    private int size;

    public HashMapOwn() {
        this.table = new Node2[16];//一般是2的整数次幂
        this.size=16;
    }

    public void put(Object key,Object value){
        //需要考虑扩容--2倍长度
        Node2 node2 = new Node2();
        node2.hash=myHashValue(key.hashCode(), size);
        node2.key=key;
        node2.value=value;
        Node2 temp = table[node2.hash];
        boolean isKeyRepeat = false;//是否重复判断
        Node2 node2Last = null;
        if(temp==null){
            table[node2.hash]= node2;
        }else {
            //不为空，需要遍历替换
            while (temp!=null){
                //1.key重复
                if(temp.key.equals(key)){
                    temp.value=value;
                    isKeyRepeat= true;
                    break;
                }else {
                    //2.key不重复
                    node2Last = temp;
                    temp = temp.next;
                }
            }
            if(!isKeyRepeat){
                node2Last.next=node2;
            }
        }
    }
    public int myHashValue(int hash,int length){
        //System.out.println("myhash:"+(hash&(length-1)));//直接位运算,效率高 两者的作用是一样的
        return hash&(length-1);
    }
    public Object get(Object key){
        int hash = myHashValue(key.hashCode(),size);
        Object val =null;
        Node2 temp = table[hash];
        while (temp!=null){
            if(temp.key.equals(key)){
                val = temp.value;
                break;
            }else {
                temp = temp.next;
            }
        }
        return val;
    }

    public void remove(Object key){
        int hash = myHashValue(key.hashCode(),size);
        Node2 prev = table[hash];
        Node2 e = prev;
        Node2 e_pre = null;
        while (e!=null) {
            Node2 next = e.next;
            if(e.key.equals(key)){
                e_pre.next=next;
                return;
            }else {
                e_pre=e;
                e = e.next;
            }
        }

    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for(int i=0;i<size;i++){
            Node2 temp = table[i];
            while (temp!=null){
                sb.append(temp.key+":"+temp.value+",");
                temp=temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');

        return sb.toString();
    }
}
class Node2{
    int hash;
    Object key;
    Object value;
    Node2 next;

    public Node2(int hash, Object key, Object value, Node2 next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node2() {
    }
}
