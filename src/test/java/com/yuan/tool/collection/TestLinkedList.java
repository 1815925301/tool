package com.yuan.tool.collection;

import org.junit.Test;

/**
 * FileName: TestLinkedList
 * Date:     2019/12/15 18:24
 */
public class TestLinkedList {
    @Test
    public void testLinkedList(){
        TLiknedlist<String> list1 = new TLiknedlist();
        list1.add("111");
        list1.add("222");
        list1.add("333");
        list1.add("444");
        list1.add("555");
        list1.add(2,"aaaa");
        System.out.println(list1.toString());
        list1.remove(5);
        System.out.println(list1.toString());
        int node = list1.getNode("444");
        System.out.println("node:"+node);
    }
}
class TLiknedlist<E>{
    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E e){

        //直接判断最后一个是否为空
        Node<E> l = last;
        Node<E> newNode = new Node<>(l,e,null);
        last = newNode;
        if(l==null){
            first=newNode;
        }else {
            l.next = newNode;
        }
        size++;
    }
    public Node<E> getNode(int index){
        checkRange(index);
        Node<E> node = node(index);
        return node;

    }
    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--){
                x = x.first;
            }
            return x;
        }
    }
    public void add(int index,E e){
        checkRange(index);
        Node<E> nodeIndex = getNode(index);
        Node<E> nodeNew = new Node<>(null,e,null);
        nodeNew.first = nodeIndex.first;
        nodeNew.next = nodeIndex;
        nodeIndex.first.next = nodeNew;
        nodeIndex.first=nodeIndex;
        size++;
    }
    public void remove(int index){
        checkRange(index);
        Node<E> nodeIndex = getNode(index);
        Node<E> firstIndex = nodeIndex.first;
        Node<E> nextIndex = nodeIndex.next;
        if(firstIndex!=null){
            firstIndex.next=nextIndex;
        }
        if(nextIndex!=null){
            nextIndex.first = firstIndex;
        }
        size--;
    }

    public int getNode(E e){
        boolean flag = true;
        int i=0;
        Node<E> e1 = first;
        while (!e1.item.equals(e)){
            e1= e1.next;
            i++;
        }
        return i;
    }
    public void checkRange(int index){
        if(!(index >= 0 && index < size)){
            throw new IllegalArgumentException("非法索引！");
        }
    }
    @Override
    public String toString() {
        StringBuffer sBB = new StringBuffer();
        Node node = first;
        Node temp = node.next;
        sBB.append(first.item+" ");
        while (temp!=null){
            Node node1 = temp;
            sBB.append(node1.item+" ");
            temp = node1.next;
        }
        System.out.println(sBB.toString());
        return "";
    }
}
class Node<E>{
    E item;
    Node<E> next;
    Node<E> first;

    public Node(Node<E> first,E element,Node<E> next){
        this.first=first;
        item=element;
        this.next=next;
    }

}
