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

    private void buildModelTest(){
        BuildModel buildModel = new BuildModel.Build("灰色").bulid();
    }
}
