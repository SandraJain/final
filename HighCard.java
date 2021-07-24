
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HighCard {
	private ArrayList<Integer> dice; 
	private int bankerDice; 
	private int playerDice;
	private boolean result; 
	private JLabel bankerLabel;
	private JLabel playerLabel;
	private ImageIcon bankerImg;
	private ImageIcon playerImg;
	private Register r;
	
	HighCard(Register r) {
		this.r=r;
		dice = new ArrayList<Integer>(6);
		for(int i = 1;i < 7;i++) {
			dice.add(i);
		}
		result = false;
	}
	
	public ArrayList<Integer> getCard() {
		return this.dice;
	}
	
	public int getBankerDice() {
		return this.bankerDice;
	}
	
	public int getPlayerDice() {
		return this.playerDice;
	}
	
	public String getResult() {
		if(result == true) {
			r.getU().setMoney(r.getU().getMoney()+500);
			return "You win!!!";
		} else {
			r.getU().setMoney(r.getU().getMoney()-500);
			return "Lose the game...";
		}			
	}
	
	public void play() {
		int banker = (int)(Math.random()*6); 
		int player = (int)(Math.random()*6);
		
		if(banker == player) {
			play();
		} else {
			this.bankerDice = getCard().get(banker);
			this.playerDice = getCard().get(player);
		}
		
		if(this.bankerDice > this.playerDice) {
			this.result = false;
		} else {
			this.result = true;
		}
	}
        public void createBankerDice(JLabel l) {
		
        bankerLabel = new JLabel();
		if(getBankerDice() == 1) {
			bankerImg = new ImageIcon(HighCard.class.getResource("pic/dice1.png"));
			bankerImg.setImage(bankerImg.getImage().getScaledInstance(175,175,Image.SCALE_DEFAULT));
			bankerLabel .setIcon(bankerImg);
			bankerLabel.setBounds(335,255,150,150);
			l.add(bankerLabel);
		} else if(getBankerDice() == 2) {
			bankerImg = new ImageIcon(HighCard.class.getResource("pic/dice2.png"));
			bankerImg.setImage(bankerImg.getImage().getScaledInstance(152,152,Image.SCALE_DEFAULT));
			bankerLabel .setIcon(bankerImg);
			bankerLabel.setBounds(335,255,150,150);
			l.add(bankerLabel);
		} else if(getBankerDice() == 3) {
			bankerImg = new ImageIcon(HighCard.class.getResource("pic/dice3.png"));
			bankerImg.setImage(bankerImg.getImage().getScaledInstance(160,160,Image.SCALE_DEFAULT));
			bankerLabel .setIcon(bankerImg);
			bankerLabel.setBounds(335,255,150,150);
			l.add(bankerLabel);
		} else if(getBankerDice() == 4) {
			bankerImg = new ImageIcon(HighCard.class.getResource("pic/dice4.png"));
			bankerImg.setImage(bankerImg.getImage().getScaledInstance(148,148,Image.SCALE_DEFAULT));
			bankerLabel .setIcon(bankerImg);
			bankerLabel.setBounds(335,255,150,150);
			l.add(bankerLabel);
		} else if(getBankerDice() == 5) {
			bankerImg = new ImageIcon(HighCard.class.getResource("pic/dice5.png"));
			bankerImg.setImage(bankerImg.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
			bankerLabel .setIcon(bankerImg);
			bankerLabel.setBounds(335,255,150,150);
			l.add(bankerLabel);
		} else {
			bankerImg = new ImageIcon(HighCard.class.getResource("pic/dice6.png"));
			bankerImg.setImage(bankerImg.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
			bankerLabel .setIcon(bankerImg);
			bankerLabel.setBounds(335,255,150,150);
			l.add(bankerLabel);
		}
	}
	public void createPlayerDice(JLabel l) {
		
		playerLabel=new JLabel();
		if(getPlayerDice() == 1) {
			playerImg = new ImageIcon(HighCard.class.getResource("pic/dice1.png"));
			playerImg.setImage(playerImg.getImage().getScaledInstance(175,175,Image.SCALE_DEFAULT));
			playerLabel.setIcon(playerImg);
			playerLabel.setBounds(545,255,150,150);
			l.add(playerLabel);
		} else if(getPlayerDice() == 2) {
			playerImg = new ImageIcon(HighCard.class.getResource("pic/dice2.png"));
			playerImg.setImage(playerImg.getImage().getScaledInstance(152,152,Image.SCALE_DEFAULT));
			playerLabel.setIcon(playerImg);
			playerLabel.setBounds(550,255,150,150);
			l.add(playerLabel);
		} else if(getPlayerDice() == 3) {
			playerImg = new ImageIcon(HighCard.class.getResource("pic/dice3.png"));
			playerImg.setImage(playerImg.getImage().getScaledInstance(160,160,Image.SCALE_DEFAULT));
			playerLabel.setIcon(playerImg);
			playerLabel.setBounds(550,255,150,150);
			l.add(playerLabel);
		} else if(getPlayerDice() == 4) {
			playerImg = new ImageIcon(HighCard.class.getResource("pic/dice4.png"));
			playerImg.setImage(playerImg.getImage().getScaledInstance(148,148,Image.SCALE_DEFAULT));
			playerLabel.setIcon(playerImg);
			playerLabel.setBounds(550,255,150,150);
			l.add(playerLabel);
		} else if(getPlayerDice() == 5) {
			playerImg = new ImageIcon(HighCard.class.getResource("pic/dice5.png"));
			playerImg.setImage(playerImg.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
			playerLabel.setIcon(playerImg);
			playerLabel.setBounds(550,255,150,150);
			l.add(playerLabel);
		} else   {
			playerImg = new ImageIcon(HighCard.class.getResource("pic/dice6.png"));
			playerImg.setImage(playerImg.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
			playerLabel.setIcon(playerImg);
			playerLabel.setBounds(550,255,150,150);
			l.add(playerLabel);
		}
	}
	
	public String getInfo() {
		play();
		return "Banker dice : "+getBankerDice()+"\n"
				+"Your dice : "+getPlayerDice()+"\n"
				+getResult();
	}
}
