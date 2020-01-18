package com.yuan.tool.network;

import com.sun.net.ssl.internal.www.protocol.https.HttpsURLConnectionOldImpl;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * FileName: 爬虫demo
 * Author:   yhl
 * Date:     2020/1/4 22:28
 * Description: ${DESCRIPTION}
 */
public class 爬虫demo {

    @Test
    public void test1() throws Exception{
        URL url = new URL("https://www.jd.com");
        BufferedReader br =
                new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu2.html"),"utf-8"));
        String msg =null;
        while((msg=br.readLine())!=null){
            bw.append(msg);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    @Test
    public void test2() throws Exception{
        URL url = new URL("https://www.dianping.com");
        //模拟浏览器访问开始
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        //模拟浏览器访问结束
        BufferedReader br =
                new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dingping2.html"),"utf-8"));
        String msg =null;
        while((msg=br.readLine())!=null){
            bw.append(msg);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
