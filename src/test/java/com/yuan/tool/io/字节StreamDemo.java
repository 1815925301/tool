package com.yuan.tool.io;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import java.io.*;

/**
 * FileName: StreamDemo
 * Author:   yhl
 * Date:     2020/1/1 20:20
 * Description: ${DESCRIPTION}
 */
public class 字节StreamDemo {

    @Test
    public void inputStream单独(){
        InputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream("adcf".getBytes());
            if(inputStream!=null){
                int temp;
                while((temp=inputStream.read())!=-1){
                    System.out.println((char) temp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void outputStream(){
        OutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            if(outputStream!=null){
                String msg = "weqwdasdada";
                outputStream.write(msg.getBytes());
                byte[] bytes = ((ByteArrayOutputStream) outputStream).toByteArray();
                String aa = new String(bytes);
                System.out.println(aa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void outStream(){
        Writer outputStream = null;
        try {
            outputStream = new FileWriter("out.txt",true);
            if(outputStream!=null){
               String aa = "io is easy!\nscadsa";
                char[] bytes = aa.toCharArray();
                outputStream.write(bytes);
                outputStream.write("wwww");
                outputStream.append("222");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void 文件copy(){
        String pathSource=System.getProperty("user.dir")+"\\abc.txt";
        String pathTarget=System.getProperty("user.dir")+"\\abcCopy.txt";
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
             inputStream = new FileInputStream(pathSource);
             outputStream = new FileOutputStream(pathTarget);
            byte[] inputBytes = new byte[2];//缓冲容器，2个2个缓冲
            while (inputStream.read(inputBytes)!=-1){
                outputStream.write(inputBytes);
                outputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
            if(outputStream!=null){
                outputStream.close();
            }
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void 图片copy(){
        String pathSource=System.getProperty("user.dir")+"\\psb.jpg";
        String pathTarget=System.getProperty("user.dir")+"\\psb1.jpg";
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            inputStream = new FileInputStream(pathSource);
            outputStream = new FileOutputStream(pathTarget);
            byte[] inputBytes = new byte[2];//缓冲容器，2个2个缓冲
            while (inputStream.read(inputBytes)!=-1){
                System.out.println("inputBytes:"+inputBytes);
                outputStream.write(inputBytes);
                outputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
