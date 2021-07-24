
import java.sql.*;
import java.util.ArrayList;

public class Register {
    private Exec e;
    private ArrayList<User> u;
    private ArrayList<House>h;
    Register() throws SQLException{
    	u=new ArrayList<User>();
    	h=new ArrayList<House>();
    	e=new Exec();
    }   
    public void add(User user) {
    	u.add(user);
    }
    public void add(House house) {
    	h.add(house);
    }
    public User getU(){
    	for(User er:u) {
    		return er;
    	}
    	return null;
    }
    public House getH(int x) {
    	return h.get(x-1);
    }
    public double getTotal(User user)throws SQLException{
    	double total=0;
    	for(House us:h) {
    		total+=e.getTotal(user,us);
    	}
    	return total;
    }
    public boolean addUser(User user)throws SQLException {
    	e.addUser(user);
    	return true;
    }
    public boolean addHouse(House house)throws SQLException {
    	e.addHouse(house);
    	return true;
    }
    public boolean addHouser(House house,User user)throws SQLException {
    	e.addHouser(house,user);
    	return true;
    }
    public boolean updateHouse(House house)throws SQLException{
    	e.updateHouse(house);
    	return true;
    }  
    public boolean updateHouser(House house,User user)throws SQLException{
    	e.updateHouser(house,user);
    	return true;
    }  
    public boolean updateUser(User user)throws SQLException{
    	e.updateUser(user);
    	return true;
    }   
    public boolean findHouse(String name)throws SQLException {
    	return e.findHouse(name);
    }
    public boolean findUser(String name,String password)throws SQLException {
    	return e.findUser(name,password);
    }
    public boolean finder(String name)throws SQLException {
    	return e.finder(name);
    }
    public boolean findHouser(String name)throws SQLException {
    	return e.findHouser(name);
    }
    public User OldUser(String name,String password)throws SQLException{
    	return e.OldUser(name, password);
    }
    public House OldHouse(String houser,String house)throws SQLException{
    	return e.OldHouse(houser,house);
    }
    public boolean delete(String name)throws SQLException{
    	return e.delete(name);
    }
}
