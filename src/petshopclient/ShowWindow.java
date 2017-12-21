package petshopclient;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import petShop.Pet;
import petShop.PetShop;
import java.net.*;
public class ShowWindow extends JFrame  implements ActionListener{

	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	  private JMenuBar mb=new JMenuBar();
	  private JMenu mCreate= new JMenu("Add Pet");
	  private JMenuItem create1=new JMenuItem("Add Cat");
	  private JMenuItem create2=new JMenuItem("Add Dog");
	  private JMenuItem create3=new JMenuItem("Add Other Pet");
	  private JMenu mSearch= new JMenu("Search");
	  private JMenuItem search1=new JMenuItem("Keyword Search");
	  private JMenuItem search2=new JMenuItem("Exact Search");
	  
	  private JMenu mDelete=new JMenu("Delete");
	  private JMenuItem delete1=new JMenuItem("Exact Delete");
	  
	  private JMenu mModify=new JMenu("Modify");
	  private JMenuItem modify1=new JMenuItem("Exact Modify");
	  
	  private JPanel pl=new JPanel();
	  private JLabel welcome=new JLabel("Welcome  PetShop~");

	  public ShowWindow(String s){
	     super(s);
	    try{
	    	mb.add(mCreate);

		    mCreate.add(create1);
		    mCreate.add(create2);
		    mCreate.addSeparator();
		    mCreate.add(create3);
		    create1.addActionListener(this);
		    create2.addActionListener(this);
		    create3.addActionListener(this);

		    mb.add(mSearch);mSearch.add(search1); mSearch.add(search2);
		    mb.add(mDelete);mDelete.add(delete1);
		    mb.add(mModify);mModify.add(modify1);
		   
		    search1.addActionListener(this);
		    search2.addActionListener(this);
		    modify1.addActionListener(this);
		    pl.add(welcome);
		    this.setJMenuBar(mb);
		    this.setLayout(new FlowLayout());
		    this.add(pl);
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }

	  }


	public void actionPerformed(ActionEvent e){
		  if(e.getActionCommand()=="Add Cat"){
			 Client.fresh();
			  new AddWindow('c',this,"Add Cat",true);
			  Client.update();
		  }else if (e.getActionCommand()== "Add Dog"){
			  Client.fresh();
			  new AddWindow('d',this,"Add Dog",true);
			  Client.update();
		  }else if (e.getActionCommand()=="Add Other Pet"){
			  Client.fresh();
			  new AddWindow('o',this,"Add Other Pet",true);
			  Client.update();
		  }else if (e.getActionCommand()=="Keyword Search"){
			  Client.fresh();
			  new KeyWordSearchWindow(this,"Keyword Search",true);
			  Client.update();
		  }
		  else if (e.getActionCommand()=="Exact Search"){
			  Client.fresh();
			  new ExactSearchWindow('p',this,"Modify Pet's Information",true);
			  Client.update();
		  }
		  else if (e.getActionCommand()=="Exact Delete"){
			  Client.fresh();
			  new ExactSearchWindow('d',this,"Modify Pet's Information",true);
			  Client.update();
		  }
		  else if (e.getActionCommand()=="Exact Modify") {
			  Client.fresh();
			  new ExactSearchWindow('m',this,"Modify Pet's Information",true);
			  Client.update();
		  }
	}
	         

}