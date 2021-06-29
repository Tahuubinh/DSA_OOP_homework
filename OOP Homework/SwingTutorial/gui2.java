package SwingTutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui2 implements ActionListener{  
    JTextField tf1,tf2,tf3;  
    JButton b1,b2,b3;  
    JLabel l1;
    gui2(){  
        JFrame f= new JFrame();  
        l1=new JLabel();  
	    l1.setBounds(50,25,100,30); 
        b1=new JButton("C");  
        b1.setBounds(50,100,50,50);  
        b2=new JButton("B");  
        b2.setBounds(50,200,50,50);  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        f.add(b1);f.add(b2); f.add(l1); 
        f.setSize(1000,1000);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
         
        if(e.getSource()==b1){  
        	l1.setText("A");
        }else if(e.getSource()==b2){  
        	new gui(); 
        } 
    }  
}  

