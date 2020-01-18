package com.yuan.tool.collection;

import com.yuan.utils.JsonUtil;
import org.junit.Test;

import java.io.FileReader;
import java.util.*;

/**
 * FileName: TestList
 * Author:   yhl
 * Date:     2019/12/15 13:49
 * Description: ${DESCRIPTION}
 */
public class TestList {
    @Test
    public void test(){
        List<String> list = new ArrayList();
        List<String> list1 = new ArrayList();
        list.add("11");
        list.add("22");
        list.add("33");
        list1.add("22");
        boolean contains = list.containsAll(list1);
        Object[] objects = list.toArray();
        System.out.println(objects[0]);
        System.out.println(contains);

        int i = list.indexOf("33");
        System.out.println(i);
    }


    @Test
    public void testLinkedList1(){
        List<String> list1 = new LinkedList<>();
        list1.add("111");
        list1.add("222");
        list1.add("333");
        System.out.println(JsonUtil.toJson(list1));
        list1.add(1,"211");
        System.out.println(JsonUtil.toJson(list1));
    }


}

