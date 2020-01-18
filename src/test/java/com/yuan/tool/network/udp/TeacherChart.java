package com.yuan.tool.network.udp;

/**
 * FileName: TeacherChart
 * Author:   yhl
 * Date:     2020/1/5 10:56
 * Description: ${DESCRIPTION}
 */
public class TeacherChart {

    public static void main(String[] args) {
        new Thread(new ChartSender(8888,"localhost",9999)).start();
        new Thread(new ChartReceiver(7777,"学生说")).start();
        }

}
