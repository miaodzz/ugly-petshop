package petshopclient;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import petShop.Pet;
import petShop.PetShop;

public class OutputOneWindow  extends JDialog implements ActionListener{
    /**
	 * 
	 */
	Pet ppet;
	PetShop petshop;
	JFrame f;
	JTextField tId=new JTextField();
	JTextField tName=new JTextField();
    JTextField tColor=new JTextField();
    JTextField tAge=new JTextField();
    JLabel IdLabel=new JLabel("The Pet's ID:");
    JLabel nameLabel=new JLabel("The Pet's Name:");
    JLabel colorLabel=new JLabel("The Pet's Color:");
    JLabel ageLabel=new JLabel("The Pet's Age:");

    JButton bDelete=new JButton("Delete");
    JButton bCancel=new JButton("OK");
    JButton bModify=new JButton("Modify");
    
    JPanel panLast=new JPanel();
    
    public OutputOneWindow(Pet ppet,JFrame f,String s,boolean b){
        super(f,s,b);
        this.f=f;
        this.ppet=ppet;
	    this.setLayout(new GridLayout(5,2));
	    this.add(IdLabel);
	    this.add(tId);
	    this.add(nameLabel);
	    this.add(tName);
	    this.add(colorLabel);
	    this.add(tColor);
	    this.add(ageLabel);
	    this.add(tAge);
	    this.add(panLast);
	    this.add(bCancel);
	    panLast.add(bModify);
	    panLast.add(bDelete);
	    tId.setText(String.valueOf(ppet.getNumber()));
	    tId.setEditable(false);
	    tName.setText(ppet.getName());
	    tColor.setText(ppet.getColor());
	    tAge.setText(String.valueOf(ppet.getAge()));
	    tName.setEditable(false);
	    tColor.setEditable(false);
	    tAge.setEditable(false);
	    bCancel.addActionListener(this);
        bDelete.addActionListener(this);
        bModify.addActionListener(this);
	    this.setBounds(320,220,350,240);
	    this.setVisible(true);
    }
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == bDelete) {// 判断触发源是否是按钮
			
			if(petshop.delete(ppet))
			{
				new SuccessWindow(this.f,"Hint",true);
				this.setVisible(false);
			}
			else{
				new ErrorWindow(this.f,"warning",true);
				this.setVisible(false);
			}
			this.setVisible(false);
		}else if(arg0.getSource()==bModify){
			new ModifyWindow(ppet,this.f,"Modify Pet's Infomation",true);
			this.setVisible(false);
			
		}else if(arg0.getSource() == bCancel){
			this.setVisible(false);
		}
			
	}
}
