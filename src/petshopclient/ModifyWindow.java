package petshopclient;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import petShop.*;
public class ModifyWindow extends JDialog implements ActionListener{

	  /**
		 * 
		 */
		JFrame f;
		private Pet ppet;
		private static final long serialVersionUID = 1L;
	    JTextField tName=new JTextField();
	    JTextField tColor=new JTextField();
	    JTextField tAge=new JTextField();

	    JLabel nameLabel=new JLabel("Pet's Name:");
	    JLabel colorLabel=new JLabel("Pet's Color:");
	    JLabel ageLabel=new JLabel("Pes's Age:");

	    JButton bCertain=new JButton("Certain");
	    JButton bQuit=new JButton("Cancel");

	    public ModifyWindow(Pet ppet,JFrame f,String s,boolean b){
	        super(f,s,b);
	        this.f=f;
	        this.ppet=ppet;
	        bCertain.addActionListener(this);
	        bQuit.addActionListener(this);
	        
	        tName.setText(this.ppet.getName());
	        tColor.setText(this.ppet.getColor());
	        tAge.setText(String.valueOf(this.ppet.getAge()));
	        
		    this.setLayout(new GridLayout(4,2));
		    this.add(nameLabel);
		    this.add(tName);
		    this.add(colorLabel);
		    this.add(tColor);
		    this.add(ageLabel);
		    this.add(tAge);
		    this.add(bCertain);
		    this.add(bQuit);
		    this.setBounds(320,220,350,200);
		    this.setVisible(true);
  }

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == bCertain) {// 判断触发源是否是按钮
			String name=tName.getText();
			String color=tColor.getText();
			int age=Integer.valueOf(tAge.getText()).intValue();
			((PetShop) Client.map.get(2)).modify(ppet, name, color, age);
			new SuccessWindow(this.f,"Hint",true);
			this.setVisible(false);
		}
		else if(arg0.getSource() == bQuit){
			this.setVisible(false);
		}
	}

};

