
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class House {
    private String name;
    private double money;
    private double data;
    private double avg;
    private int color;
    private int amount;
    private String trend;
    private ArrayList<Double> datas;
    private ArrayList<String> trends;
    
    House(String name,double money,int amount,double avg){
    	Updatedata();
    	this.name=name;
    	this.money=money;
    	this.amount=amount;
    	this.avg=avg;
    	trend="--";
    	data=0;
    	color=0;
    	datas=new ArrayList<Double>();
    	trends=new ArrayList<String>();
    }
    public String getName() {
    	return name;
    }
    public int getAmount() {
    	return amount;
    }
    public double getMoney() {
    	return money;
    }
    public double getData() {
    	return data;
    }
    public String getTrend() {
    	return trend;
    }
    public double getAvg() {
    	return avg;
    }
    public void UpdateAvg(double price,int amount) {
    	if(amount==0) {
    		avg=0;
    	}
    	else {
        	avg=(avg+price)/amount;    		
    	}
    }
    public void UpdateMoney() {
    	money+=data;
    }
    public void setAmount(int amount) {
    	this.amount=amount;
    }
    public void setAvg(double amount) {
    	avg=amount;
    }
    public void Updatedata() {
    	new Timer(80000,new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			Random r=new Random();
    	 		int x=r.nextInt(50);
    	 		color=r.nextInt(2);
    	 	    double y=r.nextDouble();
    	 		data=x+y;
    	 		datas.add(data);
    	 		if(getMoney()>=data) {
    	 			if(color==0) {
        	 			trend="¡¿";
        	 			trends.add(trend);
        	 			data=-data;
        	 			UpdateMoney();
        	 		}
        	 		else  {
        	 			trend="¡¶";
        	 			trends.add(trend);
        	 			UpdateMoney();
        	 		}
    	 		}
    	 		else {
    	 			trend="¡¶";
    	 			trends.add(trend);
    	 			UpdateMoney();
    	 		}
    		}
    	}
    	).start();    	
    }
    public String info() { 	
    	String info=String.format("Per Money : %.2f\n",getMoney());
    	info+=String.format("Own total amount:%d\n",getAmount());
    	info+=String.format("Average price of own:%.2f\n",getAvg());
    	for(String i:trends) {
    		info+=String.format("%s %.2f\n", i,datas.get(trends.indexOf(i)));
    	}    	
    	return info;
    }
}
