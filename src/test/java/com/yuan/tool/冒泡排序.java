package com.yuan.tool;

import com.yuan.utils.JsonUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * FileName: 冒泡排序
 * Author:   yhl
 * Date:     2019/12/1 0:59
 * Description: ${DESCRIPTION}
 */
public class 冒泡排序 {


    @Test
    public void testMp(){
        int intArray[] = {1,10,2,3,7,4,6,9,8,5};
        //asc
        MpMethod(intArray);
        //desc
        //二分法排序(intArray,8);
    }
    public void MpMethod(int intArray[]){
        //asc
        for(int j = 0;j<intArray.length;j++){
            boolean flag = true;
            for(int i=0;i<intArray.length-1-j;i++){
                int firstArray = intArray[i];
                int nextArray = intArray[i+1];
                if(firstArray>nextArray){
                    intArray[i+1]=firstArray;
                    intArray[i]=nextArray;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
            System.out.println(JsonUtil.toJson(intArray));
        }
        System.out.println("-------------");
    }
}
