package com.yuan.tool.io;

import com.mysql.jdbc.Buffer;
import org.junit.Test;

import java.io.*;

/**
 * FileName: StreamDemo
 * Author:   yhl
 * Date:     2020/1/1 20:20
 * Description: ${DESCRIPTION}
 */
public class 字符StreamDemo {


    @Test
    public void inputStream缓冲(){
        String path=System.getProperty("user.dir")+"\\abc.txt";
        Reader inputStream = null;
        System.out.println(path);
        try {
            inputStream = new FileReader(path);
            if(inputStream!=null){
                char by[] = new char[2];//缓冲容器
                int len;//每次读取的个数
                while((len=inputStream.read(by))!=-1){
                    String s = new String(by,0,len);//解码的操作
                    System.out.println(s);
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
        Reader inputStream=null;
        Writer outputStream=null;
        try {
             inputStream = new FileReader(pathSource);
             outputStream = new FileWriter(pathTarget);
            char[] inputBytes = new char[2];//缓冲容器，2个2个缓冲
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

    public void aaa(){
        String pathSource=System.getProperty("user.dir")+"\\abc.txt";
        String pathTarget=System.getProperty("user.dir")+"\\abcCopy.txt";
        BufferedReader inputStream=null;
        BufferedWriter outputStream=null;
        try {
            inputStream = new BufferedReader(new FileReader(pathSource));
            outputStream = new BufferedWriter(new FileWriter(pathTarget));
            String len = "";
            while ((len=inputStream.readLine())!=null){
                outputStream.write(len);
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
