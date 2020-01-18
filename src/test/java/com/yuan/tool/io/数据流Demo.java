package com.yuan.tool.io;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.yuan.utils.JsonUtil;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.OutputStreamFactory;

import java.io.*;

/**
 * FileName: 数据流Demo
 * Author:   yhl
 * Date:     2020/1/4 15:55
 * Description: ${DESCRIPTION}
 */
public class 数据流Demo implements Serializable {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(1);
        dataOutputStream.writeFloat(3);
        dataOutputStream.writeUTF("121");
        dataOutputStream.writeBoolean(true);
        dataOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        int i = dataInputStream.readInt();
        float v = dataInputStream.readFloat();
        boolean aBoolean = dataInputStream.readBoolean();
        String a = dataInputStream.readUTF();
        System.out.println(a);
        System.out.println(aBoolean);
        System.out.println(v);
        System.out.println(i);
    }

    @Test
    public void test1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        AA aa = new AA("11",2);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
        objectOutputStream.writeInt(2);
        objectOutputStream.writeObject(aa);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        int anInt = inputStream.readInt();
        System.out.println(anInt);
        Object o = inputStream.readObject();
        AA aa1 = (AA)o;
        System.out.println(JsonUtil.toJson(aa1));
    }
}
