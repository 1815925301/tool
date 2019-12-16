package com.yuan.tool;

import com.yuan.utils.JsonUtil;

import java.util.Arrays;
import java.util.List;

/**
 * FileName: TestArray
 * Author:   yhl
 * Date:     2019/12/1 0:42
 * Description: ${DESCRIPTION}
 */
public class TestArray {
    public static void main(String[] args) {
        int aa[]= {1,2};
        String s = Arrays.toString(aa);
        System.out.println(s);
        String aaa[] = {"111","3333"};
        String aaaa[] = new String[]{"1","aaa"};
        List<String> strings = Arrays.asList(aaa);
        List<String> strings1 = Arrays.asList(aaaa);
        System.out.println(JsonUtil.toJson(strings));
        System.out.println(JsonUtil.toJson(strings1));

    }
}
