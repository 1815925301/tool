package com.yuan.tool.network.udp;

/**
 * FileName: StudentChart
 * Author:   yhl
 * Date:     2020/1/5 10:56
 * Description: ${DESCRIPTION}
 */
public class StudentChart {
    public static void main(String[] args) {
        new Thread(new ChartSender(6666,"localhost",7777)).start();
        new Thread(new ChartReceiver(9999,"老师说")).start();
    }
}
