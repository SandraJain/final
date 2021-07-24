
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registerpanel extends JPanel{
	public static final int FIELD_WIDTH = 20;
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JLabel checkPasswordLabel;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPasswordField checkPasswordField;
	private JButton confirmButton;
	private JButton deleteButton;
	private JButton backButton;
    private JLabel all;
    private ImageIcon m;
	private Register r;
	
	Registerpanel(Register r)throws SQLException {
		createComp();
		this.r=r;
	}
	public JTextField getUsernameField() {
		return nameField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JPasswordField getCheckPasswordField() {
		return checkPasswordField;
	}
	public void createComp() {
		
		all= new JLabel();
		all.setPreferredSize(new Dimension(1000,650));
		m = new ImageIcon(Registerpanel.class.getResource("pic/background3.png"));
		m.setImage(m.getImage().getScaledInstance(1000,650,Image.SCALE_DEFAULT));
		all.setIcon(m);
		
		nameLabel = new JLabel("User Name:");
		nameLabel.setBounds(200, 168,300 ,300);
		all.add(nameLabel);
		nameField = new JTextField(FIELD_WIDTH);
		nameField.setBounds(350, 305,400 , 25);
		all.add(nameField);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(200, 223,300 ,300);
		all.add(passwordLabel);
		passwordField = new JPasswordField(FIELD_WIDTH);
		passwordField.setBounds(350, 360,400 , 25);
		all.add(passwordField);
		
		checkPasswordLabel = new JLabel("Check your password:");
		checkPasswordLabel.setBounds(200, 278,300 ,300);
		all.add(checkPasswordLabel);
		checkPasswordField = new JPasswordField(FIELD_WIDTH);
		checkPasswordField.setBounds(350, 415,400 ,25);
		all.add(checkPasswordField);
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(500, 500, 100, 40);
		all.add(deleteButton);
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(650, 500, 100, 40);
		all.add(confirmButton);
		backButton = new JButton("Go back");
		backButton.setBounds(200,500, 100,40);
		all.add(backButton);
		
		add(all);
		
	}
	public void addButtonListener(JPanel panel, Loginpanel loginPanel,JFrame frame) {
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
						
					if(e.getSource()==confirmButton) {
						if(nameField.getText().equals("")||passwordField.getText().equals("")||checkPasswordField.getText().equals("")) {
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame,"Please enter the all information!","Error",JOptionPane.ERROR_MESSAGE);
						}	
						else {
							try {
								if(r.finder(nameField.getText())) {
									JOptionPane o=new JOptionPane();
				    				o.showMessageDialog(null, "The username is used !","Error",JOptionPane.PLAIN_MESSAGE);
								}
								else {
									if(passwordField.getText().equals(checkPasswordField.getText())) {
										User user=new User(nameField.getText(),passwordField.getText(),10000,0,1,3000,0);
										r.addUser(user);							
									    frame.setResizable(false);
									    CardLayout card = new CardLayout();
										panel.setLayout(card);
										panel.add(loginPanel, "1");
										frame.setSize(1000,650);
										card.show(panel, "1");
										frame.setResizable(false);
								    }
								    else {
									    JFrame frame = new JFrame();
									    JOptionPane.showMessageDialog(frame,"Your password is not same.","Error",JOptionPane.ERROR_MESSAGE);
								    }
								}
								nameField.setText("");
								passwordField.setText("");
								checkPasswordField.setText("");
							}
							catch(SQLException q) {
								
							}
						}	
					}
					else if(e.getSource()==deleteButton) {
						nameField.setText("");
						passwordField.setText("");
						checkPasswordField.setText("");
					}
					else if(e.getSource()==backButton){
						CardLayout card = new CardLayout();
						panel.setLayout(card);
						panel.add(loginPanel, "1");
						frame.setSize(1000,650);
						card.show(panel, "1");
						frame.setResizable(false);
					}
			}
		}
		ActionListener listener = new ClickListener();
		confirmButton.addActionListener(listener);
		deleteButton.addActionListener(listener);
		backButton.addActionListener(listener);
	}
}