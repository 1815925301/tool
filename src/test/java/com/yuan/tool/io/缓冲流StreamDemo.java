package com.yuan.tool.io;

import org.junit.Test;

import java.io.*;

/**
 * FileName: StreamDemo
 * Author:   yhl
 * Date:     2020/1/1 20:20
 * Description: ${DESCRIPTION}
 */
public class 缓冲流StreamDemo {
    @Test
    public void demo1(){
        String path=System.getProperty("user.dir").replace("\\","\\\\")+"\\\\abx.txt";
        System.out.println(path);
        try {
            InputStream inputStream = new FileInputStream("E:\\ideaWorkSpaces\\tool\\abc.txt");
            if(inputStream!=null){
                int read1 = inputStream.read();
                int read2 = inputStream.read();
                int read3 = inputStream.read();
                int read4 = inputStream.read();
                int read5 = inputStream.read();
                System.out.println(read1);
                System.out.println(read5);
                System.out.println((char)read1);
                System.out.println((char)read2);
                System.out.println((char)read3);
                System.out.println((char)read4);
                System.out.println((char)read5);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void inputStream单独(){
        String path=System.getProperty("user.dir")+"\\abc.txt";
        InputStream inputStream = null;

        System.out.println(path);
        try {
            inputStream = new FileInputStream(path);
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
    public void inputStream缓冲(){
        String path=System.getProperty("user.dir")+"\\abc.txt";
        InputStream inputStream = null;
        BufferedInputStream bf = null;
        try {
            inputStream = new FileInputStream(path);
            bf = new BufferedInputStream(inputStream);
            if(inputStream!=null){
                byte by[] = new byte[2];//缓冲容器
                int len;//每次读取的个数
                while((len=bf.read(by))!=-1){
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
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("out.txt",true);
            if(outputStream!=null){
               String aa = "io is easy!\n";
                byte[] bytes = aa.getBytes();
                outputStream.write(bytes);
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
             inputStream = new BufferedInputStream(new FileInputStream(pathSource));
             outputStream = new BufferedOutputStream(new FileOutputStream(pathTarget));
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
