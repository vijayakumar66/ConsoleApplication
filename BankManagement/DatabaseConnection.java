package bankapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DatabaseConnection {
	Connection connection = null;
	Statement statement = null;
	int userid;
	String userpassword;
	String credit="Credit",debit="Debit";
	LocalDate date=LocalDate.now();
	double balance;
	public void insertData(long userid, String username, long mobile, int age, long accountnumber, String password) {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Root1234");
			statement = connection.createStatement();
			String sql = String.format("INSERT INTO user values('" + userid + "','" + username + "','" + mobile + "','"
					+ accountnumber + "','" + password + "','" + age + "')");
			statement.executeUpdate(sql);
			System.out.println("success...");
			connection.close();
			return;
		} catch (Exception e) {
			System.out.println("UserId already registred.");

		}
	}

	public boolean userLogin(long iuserid, String ipasssword) {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Root1234");
			statement = connection.createStatement();
			String sql = String.format("Select userid,userpassword from user where userid='" + iuserid + "' ");
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				long  usr = rs.getLong(1);
				String pass = rs.getString(2);
				if (iuserid == usr && ipasssword.equals(pass)) {
					System.out.println("Authendication success..");
					System.out.println("------------------------");
					return true;
				}
				else {
					System.out.println("!Incorrect Password");
					System.out.println("------------------------");
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	public void viewinfo(long userid)
	{
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Root1234");
			statement = connection.createStatement();
			String sql = String.format("Select * from user where userid='" + userid + "' ");
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("Name:"+rs.getString(2));
				System.out.println("UserId:"+rs.getLong(1));
				System.out.println("Mobile:"+rs.getLong(3));
				System.out.println("AccountNumber:"+rs.getLong(4));
				System.out.println("Age:"+rs.getInt(6));
				System.out.println("Password:"+rs.getString(5));
				System.out.println("------------------------------------------------");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public void transfermoney(long userid,double amount,long accountnumber)
	{
		balance=balance-amount;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Root1234");
			statement = connection.createStatement();
			String sql = String.format("INSERT INTO transaction(userid,debit,date,status,balance,accountnumber) values('" + userid + "','" + amount + "','"
					+ date + "','" + debit + "','"+balance+"','"+ accountnumber+"')");
			statement.executeUpdate(sql);
			System.out.println("---------------------------");
			System.out.println(" Money transfer success...");
			System.out.println("---------------------------");
			connection.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}
	public void deposit(long userid,double amount,long accountnumber)
	{ 
		balance=balance+amount;
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Root1234");
			statement = connection.createStatement();
			String sql = String.format("INSERT INTO transaction(userid,credit,date,balance,status,accountnumber) values('" + userid + "','" + amount + "','"
					+ date + "','" + credit + "','"+balance+"','"+ accountnumber+"')");
			statement.executeUpdate(sql);
			System.out.println("---------------------------");
			System.out.println(" Money added success...");
			System.out.println("---------------------------");
			String bal=String.format("Select SUM(balance) from transaction where userid='" + userid + "' ");
			ResultSet rs=statement.executeQuery(bal);
			while(rs.next())
			{
				balance=rs.getDouble(1);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}
	public void transactionView(long userid)
	{
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Root1234");
			statement = connection.createStatement();
			String sql = String.format("Select * from transaction where userid='" + userid + "' ");
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.print(""+rs.getLong(1));
				System.out.print("\t\t"+rs.getDouble(2));
				System.out.print("\t\t"+rs.getDouble(3));
				System.out.print("\t\t"+rs.getString(4));
				System.out.print("\t\t"+rs.getLong(5));
				System.out.print("\t\t"+rs.getString(6));
				System.out.print("\t\t"+rs.getString(7));
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
}
