package com.yuan.tool.network;

import org.junit.Test;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * FileName: InetAddressDemo
 * Author:   yhl
 * Date:     2020/1/4 21:26
 * Description: ${DESCRIPTION}
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        System.out.println("host:"+InetAddress.getLocalHost());
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress()); //返回：192.168.1.110
        System.out.println(addr.getHostName()); //输出计算机名

        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress()); //返回 163服务器的ip:61.135.253.15
        System.out.println(addr.getHostName()); //输出：www.163.com

        //根据ip得到InetAddress对象
        addr = InetAddress.getByName("192.168.245.1");
        System.out.println(addr.getHostAddress()); //返回 163服务器的ip:61.135.253.15
        System.out.println(addr.getHostName()); //输出ip而不是域名。如果这个IP地 址不存在或DNS服务器不允许进行IP地址和域名的映射，getHostName方法就直接返回这个IP地址。
    }

    @Test
    public void aaa() throws MalformedURLException {
        //绝对路径构建
        URL url = new URL("http://www.baidu.com:80/index.html?uname=bjsxt#1");
        System.out.println("协议:"+url.getProtocol());
        System.out.println("域名:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        System.out.println("资源:"+url.getFile());
        System.out.println("相对路径:"+url.getPath());
        System.out.println("锚点:"+url.getRef()); //锚点
        System.out.println("参数:"+url.getQuery());//?参数 :存在锚点  返回null ,不存在，返回正确
        url = new URL("http://www.baidu.com:80/a/");
        url = new URL(url,"b.txt"); //相对路径
        System.out.println(url.toString());
    }
}
