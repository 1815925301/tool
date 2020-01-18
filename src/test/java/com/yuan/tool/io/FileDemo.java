package com.yuan.tool.io;

import java.io.File;
import java.io.IOException;

/**
 * FileName: FileDemo
 * Author:   yhl
 * Date:     2020/1/1 16:21
 * Description: ${DESCRIPTION}
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("E:/ideaWorkSpaces/tool");
        System.out.println(file.length());
        System.out.println(file.separatorChar);
        System.out.println(file.pathSeparatorChar);
        File file1 = new File(file,"src/psb.jpg");
        System.out.println(file1.length());
        File file2 = new File("psb.jpg");
        File file21 = new File("E:/ideaWorkSpaces/tool/psb1.jpg");
        file21.createNewFile();
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        File[] files = file.listFiles();
        for(File file3 : files){
            System.out.println(file3.getName());
        }
    }
}
