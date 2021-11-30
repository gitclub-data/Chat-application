package pandey.application.chat.window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class ClientWindow {

	public ClientWindow() {
		//creating jframe
		JFrame frame=new JFrame("Id Number");
		
		//Creating upper Panel
		JPanel nameandid=new JPanel();
		nameandid.setLayout(null);
		nameandid.setBackground(new Color(7,94,84));
		nameandid.setBounds(0,0,400,100);
		frame.add(nameandid);
		//close button in panel-1
		JButton quit=new JButton("Quit");
		quit.setBounds(275,35,95,30);
		quit.setFont(new Font("Serief",Font.ITALIC,15));
		nameandid.add(quit);
		quit.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				System.exit(0);    
			        }  
			    });
		
		//NAME AND ID
		JLabel name=new JLabel("User Name :");
		name.setFont(new Font("Serief",Font.ITALIC,15));
		name.setBounds(10,20,90,30);
		name.setForeground(Color.WHITE);
		nameandid.add(name);
		
		JLabel id=new JLabel("User Id   :");
		id.setFont(new Font("Serief",Font.ITALIC,15));
		id.setBounds(10,50,80,30);
		id.setForeground(Color.WHITE);
		nameandid.add(id);
		
		//set user id and name
		
		JLabel username=new JLabel("Gaurav Pandey");
		username.setFont(new Font("Serief",Font.BOLD,15));
		username.setBounds(100,20,120,30);
		username.setForeground(Color.WHITE);
		nameandid.add(username);
		
		JLabel userid=new JLabel("872678216");
		userid.setFont(new Font("Serief",Font.BOLD,15));
		userid.setBounds(100,50,120,30);
		userid.setForeground(Color.WHITE);
		nameandid.add(userid);
		
		//Showmessagepanel
		 JPanel messagebox=new JPanel();  
	     JScrollPane scrollableArea = new JScrollPane(messagebox); 
	     scrollableArea.setBounds(0,100,400,440);
	     messagebox.setLayout(null);
	     messagebox.setPreferredSize(new Dimension(99999999,99999999));
	     scrollableArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
	     scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	     frame.add(scrollableArea);
		
	     
	     for(int i=0;i<100;i++) {
	    	 JLabel msg=new JLabel(""+i);
	    	 msg.setBounds(0,i*20,120,30);
	    	 messagebox.add(msg);
	     }
	     
			
	     
		//Creating Message Panel
		JPanel idmessageboxandbutton=new JPanel();
		idmessageboxandbutton.setLayout(null);
		idmessageboxandbutton.setBackground(new Color(7,94,84));
		idmessageboxandbutton.setBounds(0,540,400,60);
		frame.add(idmessageboxandbutton);
		
		
		//enter id number
		JLabel enterislabel=new JLabel("Id Number:");
		enterislabel.setFont(new Font("Serief",Font.BOLD,13));
		enterislabel.setBounds(0,0,120,30);
		enterislabel.setForeground(Color.WHITE);
		idmessageboxandbutton.add(enterislabel);
		
		//creating id number textfield
		JTextField enterid=new JTextField();
		enterid.setFont(new Font("Serief",Font.PLAIN,15));
		enterid.setBounds(80,0,320,30);
		idmessageboxandbutton.add(enterid);
		
		//creating textfield
		JTextField message=new JTextField();
		message.setFont(new Font("Serief",Font.PLAIN,15));
		message.setBounds(0,30,320,30);
		idmessageboxandbutton.add(message);
		
		//creating Send Button
		JButton sendmsg=new JButton("Send");
		sendmsg.setBounds(320,30,80,30);
		sendmsg.setFont(new Font("Serief",Font.ITALIC,15));
		idmessageboxandbutton.add(sendmsg);
		
		//setting properties of framne
		frame.setSize(400,600);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
