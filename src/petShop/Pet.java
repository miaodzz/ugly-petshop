package petShop;

public interface Pet{
	public String getName();			// 得到宠物的名字
	public String getColor();			// 得到宠物的颜色
	public int getAge();				// 得到宠物的年龄
	public int getNumber();			
	public boolean setName(String name);			// 得到宠物的名字
	public boolean setColor(String color);			// 得到宠物的颜色
	public boolean setAge(int age);				// 得到宠物的年龄
	public boolean setNumber(int number);
}
