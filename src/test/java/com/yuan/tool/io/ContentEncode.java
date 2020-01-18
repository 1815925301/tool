package com.yuan.tool.io;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * FileName: ContentEncode
 * Author:   yhl
 * Date:     2020/1/1 18:50
 * Description: ${DESCRIPTION}
 */
public class ContentEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "加油，努力！";
        byte[] bytes = msg.getBytes();
        System.out.println(System.getProperty("file.encoding"));

        String msgDecode = new String(bytes,0,bytes.length,"utf-8");
        System.out.println(msgDecode);
    }

    @Test
    public void aa(){
        String aa ="我";
        String a1 ="b";
        System.out.println(aa.getBytes().length);
        System.out.println(a1.getBytes().length);
    }

}
