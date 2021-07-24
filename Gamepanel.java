
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import java.sql.*;
import org.magiclen.magicaudioplayer.AudioPlayer;

public class Gamepanel extends JPanel {
	 private JLabel h1;
	 private JLabel h2;
	 private JLabel h3;
	 private JLabel h4;
	 private JLabel h5;
	 private JLabel h6;
	 private JLabel h7;
	 private JLabel h8;
	 private JLabel name,level,money;
	 private JLabel a1,a2,a3;
	 private JButton button1;
	 private JButton button2;
	 private JLabel all;
	 private ImageIcon p1;
	 private ImageIcon p2;
	 private ImageIcon p3;
	 private ImageIcon p4;
	 private ImageIcon p5;
	 private ImageIcon p6;
	 private ImageIcon p7;
	 private ImageIcon p8;
	 private ImageIcon background;
	 private Register r;
	 private JPanel p;
	 private JFrame f;
	 private Failpanel fail;
	 private Loginpanel login;
     
	 Gamepanel(Register r,JFrame f,Failpanel fail,JPanel p)throws SQLException{  
    	 this.f=f;
    	 this.p=p;
    	 this.fail=fail;
    	 this.r=r;
     }
	 
     public void create()throws SQLException {
    	 
    	 all=new JLabel();
    	 all.setPreferredSize(new Dimension(1000,610));
    	 background=new ImageIcon(Gamepanel.class.getResource("pic/background.png"));
    	 background.setImage(background.getImage().getScaledInstance(1000, 610, Image.SCALE_DEFAULT));
 		 all.setIcon(background);		 
    	 
 		 h1=new JLabel();   	
   	     p1=new ImageIcon(Gamepanel.class.getResource("pic/house1.png"));	    
   	     Mouse m1=new Mouse(h1,r.getH(1),r,this);
   	     r.updateHouse(r.getH(1));
   	     p1.setImage(p1.getImage().getScaledInstance(380, 190, Image.SCALE_DEFAULT));
   	     h1.setBounds(635, 373, 380, 190);
   	     h1.setIcon(p1);
     	 all.add(h1);
   	    	 
    	 h2=new JLabel();   	
    	 p2=new ImageIcon(Gamepanel.class.getResource("pic/house2.png"));
   	     Mouse m2=new Mouse(h2,r.getH(2),r,this); 
   	     r.updateHouse(r.getH(2));
    	 p2.setImage(p2.getImage().getScaledInstance(320, 190, Image.SCALE_DEFAULT));
    	 h2.setBounds(350, 380, 320, 190);
    	 h2.setIcon(p2);
    	 all.add(h2);
    	 
    	 h3=new JLabel();   	
    	 p3=new ImageIcon(Gamepanel.class.getResource("pic/house3.png"));
   	     Mouse m3=new Mouse(h3,r.getH(3),r,this);   
   	     r.updateHouse(r.getH(3));
    	 p3.setImage(p3.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
    	 h3.setBounds(100, 380, 250, 180);
    	 h3.setIcon(p3);
    	 all.add(h3);
    	 
    	 h4=new JLabel();   	
    	 p4=new ImageIcon(Gamepanel.class.getResource("pic/house4.png"));
   	     Mouse m4=new Mouse(h4,r.getH(4),r,this);  
   	     r.updateHouse(r.getH(4));
    	 p4.setImage(p4.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
    	 h4.setBounds(780, 145, 250, 300);
    	 h4.setIcon(p4);
    	 all.add(h4);
    	 
    	 h5=new JLabel();   	
    	 p5=new ImageIcon(Gamepanel.class.getResource("pic/house5.png"));
   	     Mouse m5=new Mouse(h5,r.getH(5),r,this);  
   	     r.updateHouse(r.getH(5));
    	 p5.setImage(p5.getImage().getScaledInstance(280, 170, Image.SCALE_DEFAULT));
    	 h5.setBounds(590, 148, 280, 170);
    	 h5.setIcon(p5);
    	 all.add(h5);
    	 
    	 h6=new JLabel();   	
    	 p6=new ImageIcon(Gamepanel.class.getResource("pic/house6.png"));
   	     Mouse m6=new Mouse(h6,r.getH(6),r,this);   
   	     r.updateHouse(r.getH(6));
    	 p6.setImage(p6.getImage().getScaledInstance(380, 240, Image.SCALE_DEFAULT));
    	 h6.setBounds(100, 160, 380, 240);
    	 h6.setIcon(p6);
    	 all.add(h6);
    	 
    	 h7=new JLabel();   	
    	 p7=new ImageIcon(Gamepanel.class.getResource("pic/house7.png"));
   	     Mouse m7=new Mouse(h7,r.getH(7),r,this); 
    	 r.updateHouse(r.getH(7));
    	 p7.setImage(p7.getImage().getScaledInstance(280, 180, Image.SCALE_DEFAULT));
    	 h7.setBounds(385, 72, 280, 180);
    	 h7.setIcon(p7);
    	 all.add(h7);
    	 
    	 h8=new JLabel();   	
    	 p8=new ImageIcon(Gamepanel.class.getResource("pic/house8.png"));
   	     Mouse m8=new Mouse(h8,r.getH(8),r,this);   	
   	     r.updateHouse(r.getH(8));
    	 p8.setImage(p8.getImage().getScaledInstance(280, 180, Image.SCALE_DEFAULT));
    	 h8.setBounds(195, -25, 280, 180);
    	 h8.setIcon(p8);
    	 all.add(h8);
    	 
    	 button1=new JButton("Casino");
    	 button1.setBounds(880, 120, 80, 30);
    	 all.add(button1);
    	 
    	 button2=new JButton("Bank");
    	 button2.setBounds(770,120, 80, 30);
    	 all.add(button2);
    	 
    	 add(all);
     }
     
     public void createInfo() {
         all.setVisible(false);
    	 name=new JLabel("Name:");
    	 name.setBounds(770,20, 80, 30);
    	 all.add(name);
    	 String name= r.getU().getName();
    	 a1=new JLabel(name);
    	 a1.setBounds(820,20, 80, 30);
    	 all.add(a1);
    	 
    	 level=new JLabel("Level:");
    	 level.setBounds(770,50, 80, 30);
    	 all.add(level);
    	 String level=Integer.toString(r.getU().getLevel());
    	 a2=new JLabel(level);
    	 a2.setBounds(820,50, 80, 30);
    	 all.add(a2);
    	 
    	 money=new JLabel("Money:");
    	 money.setBounds(770,80, 80, 30);
    	 all.add(money);
    	 String money=Double.toString(r.getU().getMoney());
    	 a3=new JLabel(money);
    	 a3.setBounds(820,80, 80, 30);
    	 all.add(a3);
    	 all.setVisible(true);
     }
     
     public void addButtonListener(JPanel panel,Casinopanel casino) {
  		
  		class ClickListener implements ActionListener{
  			public void actionPerformed(ActionEvent e) {
  				CardLayout card = new CardLayout();
  				panel.setLayout(card);
  				panel.add(casino,"1");
  				card.show(panel,"1");
  			}
  		}
  		ActionListener listener = new ClickListener();
  		button1.addActionListener(listener);
  	}
     
     public void addButtonListener(JPanel panel,Bankpanel bank) { 		
 		class ClickListener implements ActionListener{
 			public void actionPerformed(ActionEvent e) {
 				CardLayout card = new CardLayout();
 				panel.setLayout(card);
 				panel.add(bank,"1");
 				card.show(panel,"1");
 			}
 		}
 		ActionListener listener = new ClickListener();
 		button2.addActionListener(listener);
 	}
     
     public void Update()throws SQLException {
    	 a2.setVisible(false);
    	 String info=String.format("%d", r.getU().getLevel());
		 a2 = new JLabel(info);
		 a2.setBounds(820,50, 80, 30);
		 all.add(a2);
		 
		 a3.setVisible(false);
    	 String info2=String.format("%.2f", r.getU().getMoney());
		 a3 = new JLabel(info2);
		 a3.setBounds(820,80, 80, 30);
		 all.add(a3);
		 
		 if(r.getU().getMoney()+r.getU().getBalance()+r.getTotal(r.getU())<500) {
			 CardLayout card = new CardLayout();
			 p.setLayout(card);
			 p.add(fail, "1");
			 f.setSize(1000,650);
			 card.show(p, "1"); 
			 f.setResizable(false);
			 r.delete(r.getU().getName());
		 }
		 
		 r.updateUser(r.getU());
     }
}
