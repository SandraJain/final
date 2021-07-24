
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Mouse implements MouseListener  {
	 private JTextArea ta;
	 private House h;
	 private Gamepanel g;
	 private Register r;
     Mouse(JLabel l,House h,Register r,Gamepanel g)throws SQLException{
    	 this.r=r;
    	 this.h=h;
    	 this.g=g;
    	 l.add(create());
    	 l.addMouseListener(this);
     }
     public JTextArea create() {
    	 ta=new JTextArea();
 		 ta.setLayout(null);
 		 ta.setBounds(0, 30, 200,150);
 		 ta.setVisible(false);
 		 return ta;
     }
	@Override
	
	public void mouseClicked(MouseEvent e){
		// TODO Auto-generated method stub
		
		ta.setVisible(false);
		ta.setText(null);
		
		JFrame f=new JFrame("Store");
		f.setLayout(new BorderLayout());
		ImageIcon m=new ImageIcon(Mouse.class.getResource("pic/background2.png"));
		JLabel all=new JLabel();
		all.setIcon(m);
        JLabel l=new JLabel("How many land do you want to deal?");
        JTextField t=new JTextField(30);
        JButton b1=new JButton("Buy");
        JButton b2=new JButton("Sell");
        all.setPreferredSize(new Dimension(300,110));
        m.setImage(m.getImage().getScaledInstance(300,110, Image.SCALE_DEFAULT));
        l.setBounds(30, -5, 280, 50);
        all.add(l);
        t.setBounds(20, 35, 250, 20);
        all.add(t);
        b1.setBounds(40, 65, 80, 25);
        all.add(b1);
        b2.setBounds(150, 65, 80, 25);
        all.add(b2);
        f.add(all,BorderLayout.CENTER);
        f.setBounds(400, 300, 300, 147);
        f.setVisible(true);
        
        
        class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int amount=Integer.parseInt(t.getText());
		        double expense=amount*h.getMoney();
				if(amount<=0||t.getText().equals(null)) {
					JOptionPane o=new JOptionPane();
    				o.showMessageDialog(null, "You should enter the correct number!","Error",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					if(expense<=r.getU().getMoney()) {
						try {
							h.setAmount(h.getAmount()+amount);
							h.UpdateAvg(expense, h.getAmount());
							r.getU().setNum(r.getU().getNum()+1);
							r.getU().updateLevel();
							r.getU().setMoney(r.getU().getMoney()-expense);
							r.getU().setLandamount(r.getU().getLandamount()+amount);
							g.Update();
							f.dispose();
							r.updateHouser(h,r.getU());                                                  
						}
						catch(SQLException q) {
							
						}
					}
					else {
						f.dispose();
						JOptionPane o=new JOptionPane();
	    				o.showMessageDialog(null, "You do not have enough money!","Error",JOptionPane.PLAIN_MESSAGE);
					}
				}				
			}
		}
		ActionListener l2=new ButtonListener();
		b1.addActionListener(l2);
		
		class ButtoListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int amount=Integer.parseInt(t.getText());
		        double expense=amount*h.getMoney();
				if(amount==0||t.getText().equals(null)) {
					JOptionPane o=new JOptionPane();
    				o.showMessageDialog(null, "You should enter the correct number!","Error",JOptionPane.PLAIN_MESSAGE);
				}
				else {	
					if(h.getAmount()>=amount) {
						try {
							h.setAmount(h.getAmount()-amount);
							h.UpdateAvg(-expense, -h.getAmount());
							r.getU().setNum(r.getU().getNum()+1);
							r.getU().updateLevel();
							r.getU().setMoney(r.getU().getMoney()+expense);
							r.getU().setLandamount(r.getU().getLandamount()-amount);
							r.updateHouser(h,r.getU());
							g.Update();
							f.dispose();
						}
						catch(SQLException q) {
							
						}
					}
					else {
						f.dispose();
						JOptionPane o=new JOptionPane();
	    				o.showMessageDialog(null, "You do not have enough land!","Error",JOptionPane.PLAIN_MESSAGE);
					}		
				}				
			}
		}
		ActionListener l3=new ButtoListener();
		b2.addActionListener(l3);
    }
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		ta.setText(h.info());
		ta.setVisible(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		ta.setVisible(false);
		ta.setText(null);
	}
	
}
