
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import org.magiclen.magicaudioplayer.AudioPlayer;//here
import javax.swing.*;
import java.sql.*;

public class Loginpanel extends JPanel {
	private static final int FIELD_WIDTH = 50;
	private JLabel imgLabel;
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JButton startButton;
	private JButton registerButton;
	private ImageIcon icon,background;
	private JLabel backgroundLabel;
	private Register r;
	private AudioPlayer player,player2;
	public static String name;
	
	Loginpanel(Register r)throws SQLException{
		this.r=r;
		createPanel();
		createPlayer();
	}
	public void createPlayer() {
		  player = AudioPlayer.createPlayer(Loginpanel.class.getResource("pic/KahootMusic.wav"));
		  player.play();
		  player.setPlayCount(10);
		  player.setAutoClose(true);
	}
	public void createAudio() {
		  player2 = AudioPlayer.createPlayer(Loginpanel.class.getResource("pic/spring.wav"));
		  player2.play();
		  player2.setPlayCount(10);
	}
	
	public void createPanel() {
		
		backgroundLabel = new JLabel();
		backgroundLabel.setPreferredSize(new Dimension(1000,650));
		background = new ImageIcon(Loginpanel.class.getResource("pic/background1.png"));
		background.setImage(background.getImage().getScaledInstance(1000,650,Image.SCALE_DEFAULT));
		backgroundLabel.setIcon(background);
		
		imgLabel = new JLabel();
		icon = new ImageIcon(Loginpanel.class.getResource("pic/dreamcity.png"));
		icon.setImage(icon.getImage().getScaledInstance(900,500,Image.SCALE_DEFAULT));
		imgLabel.setIcon(icon);
		imgLabel.setBounds(70, -100, 900, 500);
		backgroundLabel.add(imgLabel);
		
		nameLabel = new JLabel("User Name:");
		nameLabel.setBounds(200, 238,300 ,300);
		backgroundLabel.add(nameLabel);
		nameField = new JTextField(FIELD_WIDTH);
		nameField.setBounds(350, 375,400 , 25);
		backgroundLabel.add(nameField);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(200, 303,300 ,300);
		backgroundLabel.add(passwordLabel);
		passwordField = new JPasswordField(FIELD_WIDTH);
		passwordField.setBounds(350, 440,400 , 25);
		backgroundLabel.add(passwordField);
		
		startButton = new JButton("Start");
		startButton.setBounds(550, 500,90 , 35);
		backgroundLabel.add(startButton);
		registerButton=new JButton("Register");
		registerButton.setBounds(350, 500,90 , 35);
		backgroundLabel.add(registerButton);
		
		add(backgroundLabel);
	}
	public void addButtonListener(JFrame f,JPanel p,Gamepanel game,Bankpanel b,Casinopanel c) {	
         class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				f.setResizable(false);
				if(nameField.getText().equals("")||passwordField.equals("")){
					JOptionPane o=new JOptionPane();
    				o.showMessageDialog(null, "The information is wrong !","Error",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					try {
						if(r.findUser(nameField.getText(), passwordField.getText())) {
							r.add(r.OldUser(nameField.getText(), passwordField.getText()));
							House u1=new House("House1",4900,0,0);
							House u2=new House("House2",2300,0,0);
							House u3=new House("House3",4000,0,0);
					    	House u4=new House("House4",1200,0,0);
					    	House u5=new House("House5",3100,0,0);
					        House u6=new House("House6",5500,0,0);
					    	House u7=new House("House7",1800,0,0);
					    	House u8=new House("House8",4300,0,0);
					    	if(r.findHouser(nameField.getText())==false) {
						    	r.addHouser(u1, r.OldUser(nameField.getText(), passwordField.getText()));
						    	r.addHouser(u2, r.OldUser(nameField.getText(), passwordField.getText()));
						    	r.addHouser(u3, r.OldUser(nameField.getText(), passwordField.getText()));
						    	r.addHouser(u4, r.OldUser(nameField.getText(), passwordField.getText()));
						    	r.addHouser(u5, r.OldUser(nameField.getText(), passwordField.getText()));
						    	r.addHouser(u6, r.OldUser(nameField.getText(), passwordField.getText()));
						    	r.addHouser(u7, r.OldUser(nameField.getText(), passwordField.getText()));
						    	r.addHouser(u8, r.OldUser(nameField.getText(), passwordField.getText()));			    		
					    	}
					    	if(r.findHouse(u1.getName())==false) {
						    	r.addHouse(u1);
						    	r.addHouse(u2);
						    	r.addHouse(u3);
						    	r.addHouse(u4);
						    	r.addHouse(u5);
					    		r.addHouse(u6);
					    		r.addHouse(u7);
					    		r.addHouse(u8);
					    	}
					    	else {
					    		u1=r.OldHouse(nameField.getText(),u1.getName());
								u2=r.OldHouse(nameField.getText(),u2.getName());
					    		u3=r.OldHouse(nameField.getText(),u3.getName());
					    	    u4=r.OldHouse(nameField.getText(),u4.getName());
					    	    u5=r.OldHouse(nameField.getText(),u5.getName());
					    	    u6=r.OldHouse(nameField.getText(),u6.getName());
					    	    u7=r.OldHouse(nameField.getText(),u7.getName());
					    	    u8=r.OldHouse(nameField.getText(),u8.getName());
					    	}
							r.add(u1);
							r.add(u2);
							r.add(u3);
							r.add(u4);
							r.add(u5);
							r.add(u6);
							r.add(u7);
							r.add(u8);
							game.create();
							game.createInfo();
							b.createInfo();
							b.createProgressBar();
							game.addButtonListener(p, b);
							game.addButtonListener(p, c);
							CardLayout card = new CardLayout();
							p.setLayout(card);	
							p.add(game,"1");
							card.show(p,"1");
							player.stop();
							createAudio();
						}
						else {
							JOptionPane o=new JOptionPane();
		    				o.showMessageDialog(null, "The information is wrong !","Error",JOptionPane.PLAIN_MESSAGE);
						}
					}
					catch(SQLException q) {
						JOptionPane o=new JOptionPane();
	    				o.showMessageDialog(null, "!","Error",JOptionPane.PLAIN_MESSAGE);
					}	
				}
			}
		}
		ActionListener listener = new ClickListener();
		startButton.addActionListener(listener);
	}
	public void addButtonListener2(JPanel panel2,Registerpanel registerPanel) {
		
		class ClickListener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				nameField.setText(null);
				passwordField.setText(null);
				CardLayout card = new CardLayout();
				panel2.setLayout(card);
				panel2.add(registerPanel,"1");
				card.show(panel2,"1");
			}
		}
		ActionListener listener2 = new ClickListener2();
		registerButton.addActionListener(listener2);
	}
	public JTextField getField() {
		return nameField;
	}
	public JPasswordField getPassword() {
		return passwordField;
	}
}