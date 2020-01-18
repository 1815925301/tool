package com.yuan.tool.network.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * FileName: Client
 * Author:   yhl
 * Date:     2020/1/5 12:01
 * Description: ${DESCRIPTION}
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("--client---");
        Socket client = new Socket("localhost",9999);
        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("2211");
        dataOutputStream.flush();
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        String anInt = dataInputStream.readUTF();
        System.out.println(anInt);
        dataOutputStream.close();
    }

}
