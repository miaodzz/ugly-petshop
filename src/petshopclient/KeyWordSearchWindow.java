package petshopclient;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import petShop.Pet;
import petShop.PetShop;

public class KeyWordSearchWindow extends JDialog implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame f;
	JTextField tKeyWord=new JTextField();

    JLabel iDLabel=new JLabel("please input the keyword:");

    JButton bCertain=new JButton("Certain");
    JButton bCancel=new JButton("Cancel");
    
    JPanel panLast=new JPanel();

    public KeyWordSearchWindow(JFrame f,String s,boolean b){
        super(f,s,b);
        this.f=f;
        bCertain.addActionListener(this);
        bCancel.addActionListener(this);

	    this.setLayout(new GridLayout(3,1));
	    this.add(iDLabel);
	    this.add(tKeyWord);
	    this.add(panLast);
	
	    bCertain.addActionListener(this) ;
	    bCancel.addActionListener(this);
	    panLast.add(bCertain);
	    panLast.add(bCancel);
	    this.setBounds(320,220,350,200);
	    this.setVisible(true);
	    
    }

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == bCertain) {// 判断触发源是否是按钮
			ArrayList<Pet> keyPets=((PetShop) Client.map.get(2)).search(tKeyWord.getText());
			new OutputAllWindow(keyPets,this.f,"Search Result",true);
			this.setVisible(false);
		}else if(arg0.getSource() == bCancel){
				this.setVisible(false);
		}
	}
	
};