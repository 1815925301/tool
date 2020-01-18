package com.yuan.tool.network.tcp.demo;

import java.io.Closeable;

/**
 * �ر����ķ���
 * @author Administrator
 *
 */
public class CloseUtil {
	public static void closeAll(Closeable... io){
		for(Closeable temp:io){
			try {
				if (null != temp) {
					temp.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
