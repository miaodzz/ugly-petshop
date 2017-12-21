package petshopclient;

import java.net.*;
import java.io.*;
import java.util.*;

import msocket.Server;

import petShop.PetShop;
import petshopclient.*;
public class Client{	
	static Socket s=null;
	static Map map=null;
	static ObjectInputStream inObjS = null ;	// 输入对象
	static ObjectOutputStream outObjS = null;   //发出对象
	public Client()
	{
		this.map = new HashMap();
		try {
			this.s=new Socket("127.0.0.1",6666);
			this.outObjS = new ObjectOutputStream(this.s.getOutputStream()) ;
			this.inObjS = new ObjectInputStream(this.s.getInputStream()) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("与服务器建立连接");
		ShowWindow sw=new ShowWindow("PetShop");
    	sw.setBounds(300,200,500,300);
	   	sw.setVisible(true);//启动图形界面
	}
	public void quit()
	{
		map.put(1,"q");
		try {
			outObjS.writeObject(Client.map);
			outObjS.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public static void update()
	{
		
		try{
			map.replace(1,"u");
			outObjS.writeObject(Client.map);	
			outObjS.flush();
		}catch(Exception e){						//发生异常，打印异常
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void fresh()//fresh是操作前从服务器上把新的下载下来
	{
		try{
				System.out.println("发送f给服务器");
				Client.map.clear();
				Client.map.put(1, "f");
				Client.outObjS.writeObject(Client.map);
				Client.outObjS.flush();
				Client.map = (Map)Client.inObjS.readObject();		// 接收服务器端发送的内容
				System.out.println("f收到服务器信息" );
				if(Client.map==null){
					System.out.println("map空");
				}else if((PetShop)Client.map.get(2)==null)
				{
					System.out.println("petshop空");
					System.out.println(map.get(1));//为什么只有一个没了啊
				}
				((PetShop) Client.map.get(2)).showall();
		}catch(Exception e){						//发生异常，打印异常
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {	
		Client client=new Client();
	}
}
