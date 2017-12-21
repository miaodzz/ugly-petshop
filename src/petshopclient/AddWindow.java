package petshopclient;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import petShop.Cat;
import petShop.Dog;
import petShop.OtherPet;
import petShop.Pet;
import petShop.PetShop;
import java.net.*;
public class AddWindow extends JDialog implements ActionListener{
    /**
	 * 
	 */
	Socket sock;
	char species;
	JFrame f=null;
	private static final long serialVersionUID = 1L;
	JTextField tName=new JTextField();
    JTextField tColor=new JTextField();
    JTextField tAge=new JTextField();

    JLabel nameLabel=new JLabel("Input Pet's Name:");
    JLabel colorLabel=new JLabel("Input Pet's Color:");
    JLabel ageLabel=new JLabel("Input Pes's Age:");

    JButton bAdd=new JButton("Add");
    JButton bQuit=new JButton("Cancel");

    public AddWindow(char species,JFrame f,String s,boolean b){
        super(f,s,b);
        this.species=species;
        this.f=f; 
        bAdd.addActionListener(this);
        bQuit.addActionListener(this);
        
	    this.setLayout(new GridLayout(4,2));
	    this.add(nameLabel);
	    this.add(tName);
	    this.add(colorLabel);
	    this.add(tColor);
	    this.add(ageLabel);
	    this.add(tAge);
	    this.add(bAdd);
	    this.add(bQuit);
	    this.setBounds(320,220,350,200);
	    this.setVisible(true);
  }

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == bAdd) {// 判断触发源是否是按钮
			Pet ppet=null;
			((PetShop) Client.map.get(2)).showall();
			switch(species)
			{
			case 'c':ppet=new Cat(tName.getText(),tColor.getText(),Integer.valueOf(tAge.getText()).intValue());break;
			case 'd':ppet=new Dog(tName.getText(),tColor.getText(),Integer.valueOf(tAge.getText()).intValue());break;
			case 'o':ppet=new OtherPet(tName.getText(),tColor.getText(),Integer.valueOf(tAge.getText()).intValue());break;
			}
			System.out.println(tName.getText()+tColor.getText()+Integer.valueOf(tAge.getText()).intValue());
			if((((PetShop) Client.map.get(2)).add(ppet))){
				((PetShop) Client.map.get(2)).showall();
				new OutputOneWindow(ppet,this.f,"Add Successfully!",true);
				setVisible(false);
			}
			else new ErrorWindow(this.f,"Warning",true);
		}else if(arg0.getSource() == bQuit){
			((PetShop) Client.map.get(2)).showall();
			this.setVisible(false);
		}
	 
	}


};
