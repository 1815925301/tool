package com.yuan.tool.network.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 客户端
 * 1、创建客户端 +端口
 * 2、准备数据
 * 3、打包（发送的地点 及端口）
 * 4、发送
 * 5、释放
 */
public class ChartSender implements Runnable{
	private DatagramSocket client = null;
	private InetSocketAddress inetSocketAddress=null;
	public ChartSender(int clientPort,String receiveAddress,int receivePort){
		try {
			client = new DatagramSocket(clientPort);
			inetSocketAddress=new InetSocketAddress(receiveAddress,receivePort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true){
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			try {
				String msg =bufferedReader.readLine();
				byte[] data = msg.getBytes();
				//3、打包（发送的地点 及端口） DatagramPacket(byte[] buf, int length, InetAddress address, int port)
				DatagramPacket packet = new DatagramPacket(data,data.length,inetSocketAddress);
				//发送
				client.send(packet);
				if(msg.equals("bye")){
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		//5、释放
		client.close();
	}
}
