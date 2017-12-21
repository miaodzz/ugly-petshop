package petshopclient;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import petShop.Pet;
import petShop.PetShop;

public class ExactSearchWindow extends JDialog implements ActionListener{
    /**
	 * 
	 */
	private  char next;
	private static final long serialVersionUID = 1L;
	private JFrame f;
	JTextField tId=new JTextField();

    JLabel iDLabel=new JLabel("please input the pet's ID:");

    JButton bCertain=new JButton("Certain");
    JButton bCancel=new JButton("Cancel");
    
    JPanel panLast=new JPanel();

    public ExactSearchWindow(char next,JFrame f,String s,boolean b){
        super(f,s,b);
        this.next=next;
        this.f=f;
	    this.setLayout(new GridLayout(3,1));
	    this.add(iDLabel);
	    this.add(tId);
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
			Pet ppet=(((PetShop) Client.map.get(2))).get(Integer.valueOf(tId.getText()).intValue());
			if(ppet!=null){
				this.setVisible(false);
				if(next=='d'){
					if(((PetShop) Client.map.get(2)).delete(ppet)){
						new SuccessWindow(this.f,"Hint",true);
						this.setVisible(false);
					}else{
						new ErrorWindow(this.f,"Hint",true);
						this.setVisible(false);
					}
					
				}
				else if(next=='p'){
					new OutputOneWindow(ppet,this.f,"Pet's Information",true);
					this.setVisible(false);
				}else if(next=='m'){
					new ModifyWindow(ppet,this.f,"Modify Pet's Infomation",true);
					this.setVisible(false);
				}else{
					new ErrorWindow(this.f,"Warning",true);
					this.setVisible(false);
				}
			}else if(arg0.getSource() == bCancel){
				this.setVisible(false);
			}
			
		}

	}
};