package msocket;
import java.io.*;
import java.net.*;
import java.util.*;

import petShop.*;
class MyThread extends Thread {							//自定义多线程类
	private Socket s;
	private InetAddress ip;
	ObjectInputStream buf = null ;	// 对象输入流
	ObjectOutputStream out = null ;		//对象输出流
	public MyThread(Socket s){
		this.s=s;
	}
	public void run(){
		
		BufferedReader in = null ;	    // 接收输入流
		try{
			//服务器端输出流
			ip=s.getInetAddress();						//获取客户端IP地址
			System.out.println("客户端连接 ip："+ip);
			out = new ObjectOutputStream(s.getOutputStream()) ;
			buf = new ObjectInputStream(s.getInputStream()) ;
			boolean flag=true;
			while(flag)
			{  								//无限量跟客户交谈
				Map tempmap = (Map)this.buf.readObject();		// 接收服务器端发送的内容
				System.out.println("服务器收到"+ip+"发送的请求");
				String strIn=(String) tempmap.get(1);
				if(strIn.equals("u"))
				{
					Server.map=tempmap;
					System.out.println(ip+"update请求");
					System.out.println("服务器端被"+ip+"刷新一次");
				}
				else if(strIn.equals("f"))
				{
					Server.map.replace(1, "o");
					System.out.println(ip+"fresh请求");
					out.writeObject(Server.map);
					out.flush();
					System.out.println("客户端"+ip+"刷新一次");
				}
				else if(strIn.equals("q"))
				{
					System.out.println("ip"+"quit请求");
					flag=false;
					Server.users.remove(this);
				}
				((PetShop) Server.map.get(2)).serveToFiles();
			}
		}catch(Exception e){
		}
	}

	//下面是对username和ip属性的赋值/取值方法
	public InetAddress getIp() {
		return ip;
	}
	public void setIp(InetAddress ip) {
		this.ip = ip;
	}
}