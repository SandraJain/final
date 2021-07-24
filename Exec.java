
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Timer;

public class Exec {
	private static String url;
	private static String username;
	private static String password;
	private static Connection conn;

	Exec() throws SQLException {
		String server = "jdbc:mysql://140.119.19.73:9306/";
		String database = "MG06";
		String config = "?useUnicode=true&characterEncoding=utf8";
		url = server + database;
		username = "MG06";
		password = "AeOhRb";
		initializing();
	}

	public void initializing() throws SQLException {
		conn = DriverManager.getConnection(url, username, password);
		createUserTable();
		createHouseTable();
		createHouserTable();
	}

	public boolean createUserTable() throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement(
				"CREATE TABLE IF NOT EXISTS User(Name VARCHAR(20)NOT NULL, Password VARCHAR(20)NOT NULL,Level INT(3)NOT NULL,LandAmount INT(20)NOT NULL,Money DOUBLE(20,2)NOT NULL,BankAccount DOUBLE(20,2)NOT NULL,Investimes INT(20)NOT NULL)");
		createTableStat.executeUpdate();
		return true;
	}

	public boolean createHouseTable() throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement(
				"CREATE TABLE IF NOT EXISTS House(Name VARCHAR(20)NOT NULL,PerMoney DOUBLE(20,2)NOT NULL,Data DOUBLE(20,2)NOT NULL)");
		createTableStat.executeUpdate();
		return true;
	}

	public boolean createHouserTable() throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement(
				"CREATE TABLE IF NOT EXISTS Houser(Houser VARCHAR(20)NOT NULL,House VARCHAR(20)NOT NULL,Number INT(3)NOT NULL,AveragePrice DOUBLE(20,2)NOT NULL)");
		createTableStat.executeUpdate();
		return true;
	}

	public boolean addUser(User user) throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement("INSERT INTO User VALUES(?,?,?,?,?,?,?)");
		createTableStat.setString(1, user.getName());
		createTableStat.setString(2, user.getPassword());
		createTableStat.setInt(3, user.getLevel());
		createTableStat.setInt(4, user.getLandamount());
		createTableStat.setDouble(5, user.getMoney());
		createTableStat.setDouble(6, user.getBalance());
		createTableStat.setInt(7, user.getNum());
		createTableStat.executeUpdate();
		return true;
	}

	public boolean addHouse(House house) throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement("INSERT INTO House VALUES(?,?,?)");
		createTableStat.setString(1, house.getName());
		createTableStat.setDouble(2, house.getMoney());
		createTableStat.setDouble(3, house.getData());
		createTableStat.executeUpdate();
		return true;
	}

	public boolean addHouser(House house, User user) throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement("INSERT INTO Houser VALUES(?,?,?,?)");
		createTableStat.setString(1, user.getName());
		createTableStat.setString(2, house.getName());
		createTableStat.setInt(3, house.getAmount());
		createTableStat.setDouble(4, house.getAvg());
		createTableStat.executeUpdate();
		return true;
	}

	public boolean updateHouse(House house) throws SQLException {
		new Timer(30000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement enrollStat = conn.prepareStatement("UPDATE House SET PerMoney=?  WHERE Name=?");
					enrollStat.setDouble(1, house.getMoney());
					enrollStat.setString(2, house.getName());
					enrollStat.executeUpdate();
					enrollStat = conn.prepareStatement("UPDATE House SET Data=?  WHERE Name=?");
					enrollStat.setDouble(1, house.getData());
					enrollStat.setString(2, house.getName());
					enrollStat.executeUpdate();
				} catch (SQLException q) {

				}
			}
		}).start();
		return true;
	}

	public boolean updateUser(User u) throws SQLException {
		PreparedStatement enrollStat = conn.prepareStatement("UPDATE User SET LandAmount=?  WHERE Name=?");
		enrollStat.setDouble(1, u.getLandamount());
		enrollStat.setString(2, u.getName());
		enrollStat.executeUpdate();
		enrollStat = conn.prepareStatement("UPDATE User SET Money=?  WHERE Name=?");
		enrollStat.setDouble(1, u.getMoney());
		enrollStat.setString(2, u.getName());
		enrollStat.executeUpdate();
		enrollStat = conn.prepareStatement("UPDATE User SET Level=?  WHERE Name=?");
		enrollStat.setInt(1, u.getLevel());
		enrollStat.setString(2, u.getName());
		enrollStat.executeUpdate();
		enrollStat = conn.prepareStatement("UPDATE User SET BankAccount=?  WHERE Name=?");
		enrollStat.setDouble(1, u.getBalance());
		enrollStat.setString(2, u.getName());
		enrollStat.executeUpdate();
		enrollStat = conn.prepareStatement("UPDATE User SET Investimes=?  WHERE Name=?");
		enrollStat.setInt(1, u.getNum());
		enrollStat.setString(2, u.getName());
		enrollStat.executeUpdate();
		return true;
	}

	public boolean updateHouser(House house, User user) throws SQLException {
		PreparedStatement enrollStat = conn.prepareStatement("UPDATE Houser SET Number=?  WHERE House=? AND Houser=?");
		enrollStat.setInt(1, house.getAmount());
		enrollStat.setString(2, house.getName());
		enrollStat.setString(3, user.getName());
		enrollStat.executeUpdate();
		enrollStat = conn.prepareStatement("UPDATE Houser SET AveragePrice=?  WHERE  House=? AND Houser=?");
		enrollStat.setDouble(1, house.getAvg());
		enrollStat.setString(2, house.getName());
		enrollStat.setString(3, user.getName());
		enrollStat.executeUpdate();
		return true;
	}

	public boolean findHouse(String name) throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement("SELECT * from House WHERE Name=?");
		createTableStat.setString(1, name);
		createTableStat.executeQuery();
		ResultSet result = createTableStat.getResultSet();
		if (result.next()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean findUser(String name, String password) throws SQLException {
		PreparedStatement findStuStat = conn.prepareStatement("SELECT * from User WHERE Name=? AND Password=?");
		findStuStat.setString(1, name);
		findStuStat.setString(2, password);
		findStuStat.executeQuery();
		ResultSet result = findStuStat.getResultSet();
		while (result.next()) {
			return true;
		}
		return false;
	}

	public boolean finder(String name) throws SQLException {
		PreparedStatement findStuStat = conn.prepareStatement("SELECT * from User WHERE Name=? ");
		findStuStat.setString(1, name);
		findStuStat.executeQuery();
		ResultSet result = findStuStat.getResultSet();
		while (result.next()) {
			return true;
		}
		return false;
	}

	public boolean findHouser(String name) throws SQLException {
		PreparedStatement findStuStat = conn.prepareStatement("SELECT * from Houser WHERE Houser=? ");
		findStuStat.setString(1, name);
		findStuStat.executeQuery();
		ResultSet result = findStuStat.getResultSet();
		while (result.next()) {
			return true;
		}
		return false;
	}

	public User OldUser(String name, String password) throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement("SELECT * from User WHERE Name=?");
		createTableStat.setString(1, name);
		createTableStat.executeQuery();
		ResultSet result = createTableStat.getResultSet();
		if (result.next()) {
			double money = Double.parseDouble(result.getString("Money"));
			double balance = Double.parseDouble(result.getString("BankAccount"));
			int level = Integer.parseInt(result.getString("Level"));
			int num = Integer.parseInt(result.getString("Investimes"));
			int land = Integer.parseInt(result.getString("LandAmount"));
			User u = new User(name, password, money, land, level, balance, num);
			return u;
		} else {
			return null;
		}
	}

	public House OldHouse(String houser, String house) throws SQLException {
		PreparedStatement createTableStat = conn.prepareStatement("SELECT * from Houser WHERE Houser=? AND House=?");
		createTableStat.setString(1, houser);
		createTableStat.setString(2, house);
		createTableStat.executeQuery();
		ResultSet result = createTableStat.getResultSet();
		if (result.next()) {
			int amount = Integer.parseInt(result.getString("Number"));
			double avg = Double.parseDouble(result.getString("AveragePrice"));
			PreparedStatement findEnrolledCourse = conn.prepareStatement("SELECT * from House WHERE Name = ?");
			findEnrolledCourse.setString(1, house);
			findEnrolledCourse.executeQuery();
			ResultSet result2 = findEnrolledCourse.getResultSet();
			while (result2.next()) {
				double price = Double.parseDouble(result2.getString("PerMoney"));
				House h = new House(house, price, amount, avg);
				return h;
			}
			return null;
		} else {
			return null;
		}
	}

	public boolean delete(String name) throws SQLException {
		PreparedStatement dropDateStat = conn.prepareStatement("DELETE FROM User WHERE Name=?");
		dropDateStat.setString(1, name);
		dropDateStat.executeUpdate();
		dropDateStat = conn.prepareStatement("DELETE FROM Houser WHERE Houser=?");
		dropDateStat.setString(1, name);
		dropDateStat.executeUpdate();
		return true;
	}

	public double getTotal(User user,House house)throws SQLException {
    	PreparedStatement createTableStat=conn.prepareStatement("SELECT * from Houser WHERE Houser=? AND House=?");
    	createTableStat.setString(1,user.getName());
    	createTableStat.setString(2,house.getName());
    	createTableStat.executeQuery();
    	ResultSet result=createTableStat.getResultSet();
		if (result.next()) {
			   int amount=Integer.parseInt(result.getString("Number"));
			   PreparedStatement findEnrolledCourse=conn.prepareStatement("SELECT * from House WHERE Name = ?");
			   findEnrolledCourse.setString(1,house.getName());
			   findEnrolledCourse.executeQuery();
			   ResultSet result2=findEnrolledCourse.getResultSet();
			   while(result2.next()) {
					  double price=Double.parseDouble(result2.getString("PerMoney"));
					  double total=amount*price;
					  return total;
			   }			   
		}
		return 0;
	}
}
