package msocket;

import java.io.*;
import java.net.*;
import java.util.*;

import petShop.PetShop;
public class Server{
	public static ArrayList<MyThread> users=new ArrayList<MyThread>();			//增加一个集合，装所有的用户
	public static Map<Integer, Serializable> map;
	public static void main(String[] args) throws Exception {
		Server.map = new HashMap();
		Server.map.put(1,"f");
		Server.map.put(2,new PetShop(100));
		Server.map.replace(2,((PetShop) Server.map.get(2)).dserveFromFiles());
		System.out.println("showall:");
		((PetShop) Server.map.get(2)).showall();
		ServerSocket server=null; 						//服务器端
		try{
			System.out.println("服务器开启");
			server=new ServerSocket(6666); 			//绑定服务器在6666口
			while(true){
				System.out.println("服务器等待请求");
				//死循环，无限量接受请求
				//accept方法会阻塞在此处当接到客户请求的时候才会继续执行
				//返回一个跟客户端的连接Socket
				Socket s=server.accept();
				MyThread mt=new MyThread(s); 		//创建线程对象
				mt.start();								//启动线程
				users.add(mt); 						//将此线程加入用户列表
				//服务器端继续循环接受客户请求
			}
		}catch(Exception e){ 							//发现异常，打印异常信息
			e.printStackTrace(); 
		}
	}
}