package com.yuan.tool;

import com.yuan.utils.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FileName: CommonTest
 * Author:   yhl
 * Date:     2019/7/14 10:55
 * Description: ${DESCRIPTION}
 */
public class CommonTest {

    @Test
    public void testList(){
        String[] myArray = { "Apple", "Banana", "Orange" };
        List<String> myList = Arrays.asList(myArray);
        myList.set(0,"222");
        System.out.println(myList.size());
        System.out.println(myList.get(0));
        System.out.println(myList.getClass());
        int[] intArray = {1,2,3};
        List myList1 = Arrays.asList(intArray);
        System.out.println(myList1.size());
        System.out.println(myList1.get(0));
        List<String> list1 = new ArrayList<>();
        System.out.println(list1.getClass());

        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));

        list.add(2,"2");
        System.out.println("list:"+JsonUtil.toJson(list));
    }
    String[] src = {"a","b","c","d","e","","","","",""};
    @Test
    public void testArrayCopy(){
        System.out.println(src.length);
        System.arraycopy(src,1,src,2,8);
        System.out.println(Arrays.toString(src));
        src[1]="222";
        System.out.println(Arrays.toString(src));
        delete(1);
    }

    private void delete(int index){
        System.out.println("11:"+Arrays.toString(src));
        System.arraycopy(src,index+1,src,index,src.length-index-1);
        System.out.println("112:"+Arrays.toString(src));
        System.out.println(src.length);
        int length=src.length;
        src[--length] = null;
        System.out.println("112:"+Arrays.toString(src));
    }
}
