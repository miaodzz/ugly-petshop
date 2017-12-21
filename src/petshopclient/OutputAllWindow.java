package petshopclient;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import petShop.Pet;
import petShop.PetShop;


public class OutputAllWindow  extends JDialog implements ActionListener{
    /**
	 * 
	 */
	ArrayList<Pet> pets=null;
	JFrame f;	
	JPanel pan=new JPanel();
	JScrollPane sp=new JScrollPane(pan);
	JTextField tId=new JTextField();
	JTextField tName=new JTextField();
    JTextField tColor=new JTextField();
    JTextField tAge=new JTextField();
    JLabel IdLabel=new JLabel("ID");
    JLabel nameLabel=new JLabel("Name");
    JLabel colorLabel=new JLabel("Color");
    JLabel ageLabel=new JLabel("Age");

    JButton bDelete=new JButton("Delete");
    
    
    JPanel panLast=new JPanel();
    
    public OutputAllWindow(ArrayList<Pet> pets,JFrame f,String s,boolean b){
        super(f,s,b);
        this.f=f;
        this.pets=pets;
        this.add(sp);
	    pan.setLayout(new GridLayout(pets.size()+1,4));
	    pan.add(IdLabel);
	    pan.add(nameLabel);
	    pan.add(colorLabel);
	    pan.add(ageLabel);
	    for(int i=0;i<pets.size();i++){
	    	pan.add(new JTextField(String.valueOf(pets.get(i).getNumber())));
	    	pan.add(new JTextField(pets.get(i).getName()));
	    	pan.add(new JTextField(pets.get(i).getColor()));
	    	pan.add(new JTextField(String.valueOf(pets.get(i).getAge())));
	    }
	    if(pets.size()>8)
	    	this.setBounds(320,200,400,300);
	    else this.setBounds(320,200,400,30*pets.size()+80);
	    this.setVisible(true);
    }

	public void actionPerformed(ActionEvent arg0) {
	}
}
