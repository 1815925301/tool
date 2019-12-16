package com.yuan.tool.collection;

import javafx.beans.binding.ObjectExpression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * FileName: 泛型
 * Author:   yhl
 * Date:     2019/12/15 9:32
 * Description: ${DESCRIPTION}
 */
public class 泛型 {
    public static void main(String[] args) {
        CommonResult<String> commonResult = new CommonResult<>();
        commonResult.add("1",0);
        String s = commonResult.get(0);
        System.out.println(s);
    }


}
class CommonResult<T>{
    Object objs[] = new Object[5];

    public T get(int index){
        return (T) objs[index];
    }
    public void add(T t,int index){
        objs[index]=t;
    }
}


