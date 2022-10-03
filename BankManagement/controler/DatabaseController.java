package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DatabaseController {
	ResultSet resultSet;
	LocalDate date = LocalDate.now();
	String credit = "Credit", debit = "Debit";
	double balance;

	public ResultSet loginCheack(long userId) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root",
					"Root1234");
			Statement statement = connection.createStatement();
			String sql = String.format("Select userid,userpassword from user where userid='" + userId + "' ");
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return resultSet;
	}

	public ResultSet transactionView(long userid) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root",
					"Root1234");
			Statement statement = connection.createStatement();
			String sql = String.format("Select * from transaction where userid='" + userid + "' ");
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return resultSet;
	}

	public boolean insertNewUser(long userid, String username, long mobile, long accountnumber, int age,
			String password, String email) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root",
					"Root1234");
			Statement statement = connection.createStatement();
			String sql = String.format("INSERT INTO user values('" + userid + "','" + username + "','" + mobile + "','"
					+ accountnumber + "','" + password + "','" + age + "','" + email + "')");
			statement.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public ResultSet viewInfromation(long userid) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root",
					"Root1234");
			Statement statement = connection.createStatement();
			String sql = String.format("Select * from user where userid='" + userid + "' ");
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return resultSet;
	}

	public void moneyTransfer(long userid, double amount) {
		balance = balance - amount;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root",
					"Root1234");
			Statement statement = connection.createStatement();
			String sql = String.format("INSERT INTO transaction(userid,debit,date,status) values('" + userid + "','"
					+ amount + "','" + date + "','" + debit + "')");
			statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addMoney(long userid, double amount) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root",
					"Root1234");
			Statement statement = connection.createStatement();
			String sql = String.format("INSERT INTO transaction(userid,credit,date,status) values('" + userid + "','"
					+ amount + "','" + date + "','" + credit + "')");
			statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ResultSet showBalanceView(long userid) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root",
					"Root1234");
			Statement statement = connection.createStatement();
			String sql = String.format("Select credit,debit from transaction where userid='" + userid + "' ");
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return resultSet;
	}
}
