
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class User {
     private String name;
     private String password;
     private int level;
     private double money;
     private double balance;
 	 private double interestRate;
     private int landamount;
     private int num;
     
     User(String name,String password,double money,int landamount,int level,double balance,int num){
    	 this.name=name;
    	 this.password=password;
    	 this.landamount=landamount;
    	 this.level=level;
    	 this.money=money;
    	 this.num=num;
    	 this.balance=balance;
    	 interestRate = 0.01;    	 
     }
     public String getName() {
    	 return name;
     }
     public String getPassword() {
    	 return password;
     }
     public int getLevel() {
    	 return level;
     }
     public double getMoney() {
    	 return money;
     }
     public int getNum() {
    	 return num;
     }
     public int getLandamount() {
    	 return landamount;
     }
     public void updateLevel() {
    	 if(getNum()>5) {
    		 level=2;
    		 money+=150; 		 
    	 }
    	 else if(getNum()>20){
    		 level=3;
    		 money+=400;
    	 }
    	 else if(getNum()>50){
    		 level=4;
    		 money+=1500;
    	 }
    	 else if(getNum()>100) {
    		 level=5;
    		 money+=3000;
    	 }
     }
     public void setNum(int num) {
    	 this.num=num;
     }
     public void setMoney(double money) {
    	 this.money=money;
     }
     public void setLandamount(int amount) {
    	 landamount=amount;
     }
     public void deposit(double amount) {
    	balance += amount;
     	money-=amount;
    	
 	 }
 	 public void withdraw(double amount) {
 		balance -= amount;
	 	money+=amount;
 	 }
 	 public double getBalance() {
 		return balance;
 	 }
 	 public double updateBalance() {
 		balance = balance*(1+interestRate);
 		return balance;
 	 }
}
