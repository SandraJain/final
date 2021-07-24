
import javax.swing.*;

import org.magiclen.magicaudioplayer.AudioPlayer;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Failpanel extends JPanel {
	private JLabel imgLabel;
	private JLabel backgroundLabel;
	private JButton restart;
	private JButton leave;
	private ImageIcon background;
	private ImageIcon icon;
	private Loginpanel login;

	
	Failpanel() {
		createPanel();
		
	}

	public void createPanel() {
		backgroundLabel = new JLabel();
		backgroundLabel.setPreferredSize(new Dimension(1000, 650));
		background = new ImageIcon(Failpanel.class.getResource("pic/background6.png"));
		background.setImage(background.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT));
		backgroundLabel.setIcon(background);

		imgLabel = new JLabel();
		icon = new ImageIcon(Failpanel.class.getResource("pic/fail.png"));
		icon.setImage(icon.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT));
		imgLabel.setIcon(icon);
		imgLabel.setBounds(65, 0, 900, 500);
		backgroundLabel.add(imgLabel);

		leave = new JButton("Exit");
		leave.setBounds(600, 500, 120, 42);
		backgroundLabel.add(leave);
		restart = new JButton("Start again!");
		restart.setBounds(300, 500, 120, 42);
		backgroundLabel.add(restart);

		add(backgroundLabel);
	}

	public void addButtonListener(JPanel panel1, Loginpanel loginPanel, JFrame frame) {
		class restartListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = new CardLayout();
				panel1.setLayout(c);
				panel1.add(loginPanel, "1");
				if (e.getSource() == restart) {
					c.show(panel1, "1");
					loginPanel.getField().setText("");
					loginPanel.getPassword().setText("");
				} else if (e.getSource() == leave) {
					frame.dispose();
				}
			}
		}
		ActionListener listener = new restartListener();
		restart.addActionListener(listener);
		leave.addActionListener(listener);
	}
}
