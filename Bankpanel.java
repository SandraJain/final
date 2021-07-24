
//import java.awt.*;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Bankpanel extends JPanel {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 300;
	public static final int FIELD_WIDTH = 10;
	public static final int COLUMN = 40;
	public static final int MIN_PROGRESS = 0;
	public static final int MAX_PROGRESS = 100;
	public static int currentProgress = MIN_PROGRESS;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton goBack;
	private JLabel valueLabel;
	private JLabel all;
	private JLabel money;
	private JLabel amount;
	private ImageIcon background;
	private JTextField valueField;
	private JProgressBar progressBar;
    private Register r;
    private Gamepanel g;
    
	Bankpanel(Register r,Gamepanel g) {
		this.g=g;
		this.r=r;
		createPanel();
	}
	
	public void createPanel() {
		
		all=new JLabel();
   	    all.setPreferredSize(new Dimension(1000,610));
   	    background=new ImageIcon(Bankpanel.class.getResource("pic/background4.png"));
   	    background.setImage(background.getImage().getScaledInstance(1000, 610, Image.SCALE_DEFAULT));
		all.setIcon(background);	
		
		money = new JLabel("Money:");
		money.setBounds(230, 200,300 ,300);
		all.add(money);
		
		valueLabel = new JLabel("Value:");
		valueLabel.setBounds(230, 263,300 ,300);
		all.add(valueLabel);
		valueField = new JTextField(FIELD_WIDTH);
		valueField.setBounds(380, 400,400 , 25);
		all.add(valueField);
		
		goBack = new JButton("Go Back");
		goBack.setBounds(650,500, 100,40);
		all.add(goBack);
		
		add(all);
		
	}
	
    public void createProgressBar() {
    	
		progressBar = new JProgressBar();
		progressBar.setMinimum(MIN_PROGRESS);
		progressBar.setMaximum(MAX_PROGRESS);
		progressBar.setValue(currentProgress);
		progressBar.setStringPainted(true);
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// System.out.println("Now:"+progressBar.getValue()+";"+"Percentage:"+progressBar.getPercentComplete());
			}
		});

		new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentProgress++;
				if (currentProgress > MAX_PROGRESS) {
					r.getU().updateBalance();
					currentProgress = MIN_PROGRESS;
				}
				progressBar.setValue(currentProgress);
			}
		}).start();
		
	}
	
    public void createInfo() {
    	
    	String info=String.format("%.2f", r.getU().getBalance());
		amount = new JLabel(info);
		amount.setBounds(380, 200,300 ,300);
		all.add(amount);
		
    	depositButton = new JButton("Deposit");
		depositButton.setBounds(250, 500, 100, 40);
    	all.add(depositButton);
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				amount.setVisible(false);
				try {
					if (valueField.equals("")) {
						throw new NumberFormatException();
					}
					else {
						double money=Double.parseDouble(valueField.getText());					
						valueField.setText(null);
						if(money>r.getU().getBalance()) {
							String info=String.format("%.2f", r.getU().getBalance());
							amount = new JLabel(info);
							amount.setBounds(380, 200,300 ,300);
							all.add(amount);
							JOptionPane o=new JOptionPane();
							o.showMessageDialog(null, "You do not have enough money!","Error",JOptionPane.PLAIN_MESSAGE);
						}
						else {
							r.getU().deposit(money);
							String info=String.format("%.2f", r.getU().getBalance());
							amount = new JLabel(info);
							amount.setBounds(380, 200,300 ,300);
							all.add(amount);
							g.Update();
						}
					}
				} 
				catch(SQLException q) {
					
				}
				catch (NumberFormatException event) {
					String info=String.format("%.2f",r.getU().getBalance());
					amount = new JLabel(info);
					amount.setBounds(380, 200, 300, 300);
					all.add(amount);
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Number must be above 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		ActionListener listener = new ClickListener();
		depositButton.addActionListener(listener);

		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(400, 500, 100, 40);
    	all.add(withdrawButton);
		class ClickListener2 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				amount.setVisible(false);
				try {
					if (valueField.equals("")) {
						throw new NumberFormatException();
					}
					else {
						double money=Double.parseDouble(valueField.getText());
						valueField.setText(null);
						if(money>r.getU().getBalance()) {
							String info=String.format("%.2f", r.getU().getBalance());
							amount = new JLabel(info);
							amount.setBounds(380, 200,300 ,300);
							all.add(amount);
							JOptionPane o=new JOptionPane();
							o.showMessageDialog(null, "You do not have enough money!","Error",JOptionPane.PLAIN_MESSAGE);
						}
						else {
							r.getU().withdraw(money);
							String info=String.format("%.2f", r.getU().getBalance());
							amount = new JLabel(info);
							amount.setBounds(380, 200,300 ,300);
							all.add(amount);
							g.Update();
						}
					}
				} 
				catch(SQLException q) {
					
				}
				catch (NumberFormatException event) {
					String info=String.format("%.2f",r.getU().getBalance());
					amount = new JLabel(info);
					amount.setBounds(380, 200, 300, 300);
					all.add(amount);
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Number must be above 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		}
		ActionListener listener2 = new ClickListener2();
		withdrawButton.addActionListener(listener2);
    }
    
	public void addButtonListener(JPanel panel,Gamepanel game,JFrame frame) {
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = new CardLayout();
				panel.setLayout(card);
				panel.add(game, "1");
				frame.setSize(1000,650);
				card.show(panel, "1");
				frame.setResizable(false);
			}
		}
		ActionListener listener = new ClickListener();
		goBack.addActionListener(listener);
	}
}
