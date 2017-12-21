package petShop;

import java.io.Serializable;

public class Dog implements Pet, Serializable {
	private String name;				// 宠物名字
	private String color;				// 宠物颜色
	private int age;				// 宠物年龄
	private int number;
	public Dog(String name, String color, int age) {		// 通过构造设置属性
		this.setName(name) ;
		this.setColor(color) ;
		this.setAge(age) ;
	}
	public String getName(){return name;}			// 得到宠物的名字
	public String getColor(){return color;}			// 得到宠物的颜色
	public int getAge(){return age;}	
	public boolean setName(String name){ this.name=name; return true;}			// 修改宠物的名字
	public boolean setColor(String color){ this.color=color; return true;}			// 修改宠物的颜色
	public boolean setAge(int age){this.age=age;return true;}	
	public int getNumber() {return number;}
	public boolean setNumber(int number) {this.number = number;return true;}	
	
};
