package com.yuan.tool.network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * FileName: Sever
 * Author:   yhl
 * Date:     2020/1/5 12:01
 * Description: ${DESCRIPTION}
 */
public class Sever {
    public static void main(String[] args) throws IOException {
        System.out.println("sever----");
        ServerSocket server =new ServerSocket(9999);
        Socket client =server.accept();
        System.out.println("建立连接");
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        String anInt = dataInputStream.readUTF();
        System.out.println(anInt);
        String back = "我收到了";
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
        dataOutputStream.writeUTF(back);
    }

}
