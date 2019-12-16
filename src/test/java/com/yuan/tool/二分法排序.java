package com.yuan.tool;

import java.util.Arrays;

/**
 * FileName: 二分法排序
 * Author:   yhl
 * Date:     2019/12/1 0:59
 * Description: ${DESCRIPTION}
 */
public class 二分法排序 {

    public static void main(String[] args) {
        int intArray[]={1,2,3,4,5,6,7,8,9,10};
        Arrays.sort(intArray);
        int a = binarySearch(intArray,6);
        System.out.println(a);
        }

        static private int binarySearch(int []intArray,int key){
            int begin = 0;
            int end = intArray.length-1;
            while(begin<=end){
                int middle_index = (begin+end)/2;
                int middle_value = intArray[middle_index];
                if(key<middle_value){
                    end = middle_index-1;
                }else if(key>middle_value){
                    begin=middle_index+1;
                }else {
                    return middle_index;
                }
            }
            return -1;
        }
}
