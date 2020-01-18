package com.yuan.tool.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * 1、创建服务端 +端口
 * 2、准备接受容器
 * 3、封装成 包
 * 4、接受数据
 * 5、分析数据
 * 6、释放
 *
 */
public class ChartReceiver implements Runnable{
	DatagramSocket server;
	String fromSay;
	public ChartReceiver(int receivePort,String fromSay){
		//1、创建服务端 +端口
		try {
			server = new DatagramSocket(receivePort);
			this.fromSay=fromSay;
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true){
			//2、准备接受容器
			byte[] container = new byte[1024];
			//3、封装成 包 DatagramPacket(byte[] buf, int length)
			DatagramPacket packet =new DatagramPacket(container, container.length) ;
			//4、接受数据
			try {
				server.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//5、分析数据
			byte[] data =packet.getData();
			int len =packet.getLength();
			String msg = new String(data,0,len);
			System.out.println(fromSay+":"+msg);
			if(msg.equals("bye")){
				break;
			}
		}
		//6、释放
		server.close();

	}
}
