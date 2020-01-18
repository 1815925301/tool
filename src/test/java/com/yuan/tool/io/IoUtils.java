package com.yuan.tool.io;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * FileName: IoUtils
 * Author:   yhl
 * Date:     2020/1/4 18:21
 * Description: ${DESCRIPTION}
 */
public class IoUtils {

        public static void main(String[] args) throws Exception {
            String encoding = "UTF-8";
            InputStream inputStream = new URL("https://www.baidu.com/").openStream();
            // 01读取链接地址网页
            String s = IOUtils.toString(inputStream, encoding);
            System.out.println(s);
        }

}
