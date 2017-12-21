package petshopclient;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import petShop.Pet;
import petShop.PetShop;

public class SuccessWindow extends JDialog implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    JLabel errorLabel=new JLabel("The operation worked.");

    JButton bCertain=new JButton("OK");
    

    public SuccessWindow(JFrame f,String s,boolean b){
        super(f,s,b);
        bCertain.addActionListener(this);

	    this.setLayout(new GridLayout(2,1));
	    this.add(errorLabel);
	    this.add(bCertain);
	
	    bCertain.addActionListener(this) ;
	    this.setBounds(360,300,200,70);
	    this.setVisible(true);
	    
    
    }
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == bCertain) {// 判断触发源是否是按钮
			this.setVisible(false);
		}
			
	}
};