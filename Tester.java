
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Tester  {
	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame("Team 6's game!!");
		JPanel p = new JPanel();
		CardLayout card = new CardLayout();
		p.setLayout(card);
		
		Register r=new Register();
		Registerpanel register = new Registerpanel(r);
		Loginpanel login = new Loginpanel(r);
		Failpanel fail = new Failpanel();
		Gamepanel game=new Gamepanel(r,f,fail,p);
		Bankpanel bank = new Bankpanel(r,game);
		Casinopanel casino=new Casinopanel(r,game,p,f);
		
		p.add(login,"1");
		p.add(register,"2");
		p.add(game,"3");
		p.add(bank,"4");
		p.add(casino,"5");
		p.add(fail,"6");
		fail.addButtonListener(p,login,f);
		login.addButtonListener(f,p,game,bank,casino);
		login.addButtonListener2(p, register);
		bank.addButtonListener(p,game,f);
		register.addButtonListener(p, login,f);
		
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000,650);
		f.setContentPane(p);
		f.setResizable(false);
		
	}
}