package petShop;
import java.io.*;
import java.util.ArrayList;
public class PetShop implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PetShop petshop;
	
	ArrayList<Pet> pets =null;				// 保存多个属性
	int allNumber = 0;
	int len=0;
	public PetShop(int len) {				// 构造方法开辟宠物数组的大小
		pets= new ArrayList<Pet>();
		if(len>0) this.len=len;
	}
	public PetShop getPetShop(int len){
		if(petshop==null){
			petshop=new PetShop(len);
			
		}
		return petshop;
	}
	private void Reset(ArrayList<Pet> pets,int allNumber,int len)
	{
		this.len=len;this.allNumber=allNumber;
		for(int i=0;i<pets.size();i++)
		{
			this.pets.set(i, pets.get(i));
		}
	}
	public boolean add(Pet pet,boolean numHaveAllo) {			// 增加宠物
		if(numHaveAllo==true)
		{
			this.add(pet);
			return true;
		}
		if (this.pets.size() < this.len-1) {		// 判断宠物商店里的宠物是否已经满了
			pet.setNumber(++allNumber);
			this.pets.add(pet);		// 增加宠物
			return true;			// 增加成功
		} else {					
			return false;			// 增加失败
		}
	}
	public boolean add(Pet pet) {			// 增加宠物
		if (this.pets.size() < this.len-1) {		// 判断宠物商店里的宠物是否已经满了
			pet.setNumber(++allNumber);
			this.pets.add(pet);		// 增加宠物
			return true;			// 增加成功
		} else {					
			return false;			// 增加失败
		}
	}
	
	public boolean delete(Pet pet){           //删除宠物
		if (this.pets.size()>1) {		// 判断宠物商店里是否还有宠物
			for(int i=0; i<this.pets.size(); ++i ){
				if(pets.get(i)==pet){
					pets.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public Pet get(int number){					//Get宠物
		for(int i=0;i<this.pets.size();i++){
			if(this.pets.get(i)!=null&&this.pets.get(i).getNumber()==number){
				return this.pets.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Pet> search(String keyWord){ 	// 关键字查找
		ArrayList<Pet> P=new ArrayList<Pet>();			// 根据已经确定的记录数，开辟对象数组
		for (int i = 0; i < this.pets.size(); i++) {
			if (this.pets.get(i) != null) {
				if (this.pets.get(i).getName().indexOf(keyWord) != -1
					|| this.pets.get(i).getColor().indexOf(keyWord) != -1) {
					P.add(this.pets.get(i)); // 将符合查询条件的宠物信息保存
				}
			}
		}
		return P;
	}
	
	public boolean modify(Pet pet,String name,String color,int age){           //修改宠物
		pet.setAge(age);
		pet.setName(name);
		pet.setColor(color);
		return true;
	}
	
	public boolean showall()
	{
		System.out.println("ShowAll:");
		for(int i=0;i<this.pets.size();i++)
		{
			if(this.pets.get(i)!=null)
				System.out.println(this.pets.get(i).getNumber()+this.pets.get(i).getName()+this.pets.get(i).getColor()+this.pets.get(i).getAge());
		}
		return true;
	}
	public void serveToFiles() throws Exception {
			
		File f = new File("d:" + File.separator + "PetInShop"+File.separator+"data.dat") ;	// 定义保存路径
		if(f.exists())
		{
			f.delete();
			f.createNewFile();
		}
		ObjectOutputStream oos = null ;	// 声明对象输出流
		OutputStream out = new FileOutputStream(f) ;	// 文件输出流
		oos = new ObjectOutputStream(out) ;
		oos.writeObject(this) ;	// 保存对象
		oos.close() ;	// 关闭
	}
	public PetShop dserveFromFiles() throws Exception {
		File f=new File("d:"+File.separator+"PetInShop"+File.separator+"data.dat");
		if(f.exists()){
		InputStream input = new ObjectInputStream(new FileInputStream(f)) ;	// 文件输入流
		PetShop temp = (PetShop) ((ObjectInputStream) input).readObject() ;	// 读取对象
		input.close() ;	// 关闭
		return temp;
		}
		else{
			f.createNewFile();
			return this;
		}
	}
	
	public void setallNumber(int allNumber)
	{
		this.allNumber=allNumber;
	}
	public int getallNumber()
	{
		return this.allNumber;
	}

};
