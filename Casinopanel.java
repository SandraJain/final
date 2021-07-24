
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Casinopanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private HighCard card;
	private ImageIcon background;
	private JLabel all;
	private JTextArea resultArea;
	private JButton playButton;
	private JButton exitButton;
	private Register r;
	private Gamepanel g;
	private JPanel p;
	private JFrame f;
	
	Casinopanel(Register r,Gamepanel g,JPanel p,JFrame f) {
		this.p=p;
		this.f=f;
		this.g=g;
		this.r=r;
		createPanel();	
	}
	
	public void createPanel() { 
		
		all=new JLabel();
   	    all.setPreferredSize(new Dimension(1000,610));
   	    background=new ImageIcon(Casinopanel.class.getResource("pic/background5.png"));
   	    background.setImage(background.getImage().getScaledInstance(1000, 610, Image.SCALE_DEFAULT));
		all.setIcon(background);		
		
		resultArea=new JTextArea();
		resultArea.setText("Do you wanna spend $500 playing a game?"+"\n\n"+"The one who gets bigger point wins.");
		resultArea.setBounds(290, 440, 450,80);
		all.add(resultArea);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(600,550, 80,30);
		all.add(exitButton);
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = new CardLayout();
				p.setLayout(card);
				p.add(g, "1");
				f.setSize(1000,650);
				card.show(p, "1");
				f.setResizable(false);
				resultArea.setText("Do you wanna spend $500 playing a game?"+"\n\n"+"The one who gets bigger point wins.");
				try {
					g.Update();
				}
				catch(SQLException q) {
					
				}
			}
		}		
		ActionListener listener = new ClickListener();
		exitButton.addActionListener(listener);
		
		playButton =new JButton("Play");
		playButton.setBounds(350,550, 80,30);
		all.add(playButton);
		addB();
		
		add(all);
		
	}
	public void addB() {
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				    if(r.getU().getMoney()<500) {
				    	JOptionPane o=new JOptionPane();
	    				o.showMessageDialog(null, "You do not have enough money!","Error",JOptionPane.PLAIN_MESSAGE);
	    				CardLayout card = new CardLayout();
	    				p.setLayout(card);
	    				p.add(g, "1");
	    				f.setSize(1000,650);
	    				card.show(p, "1");
	    				f.setResizable(false);				    
				    }
				    else {
				    	card = new HighCard(r);
						all.setVisible(false);	
						createPanel();
						resultArea.setText(card.getInfo());
						card.createPlayerDice(all); 
						card.createBankerDice(all); 
				    }					
			}
		}
		ActionListener listener = new ClickListener();
		playButton.addActionListener(listener);
	}
}