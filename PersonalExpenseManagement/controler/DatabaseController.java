package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import model.ExpenseTransaction;

public class DatabaseController {
	Connection connection = null;
	Statement statement = null;
	LocalDate date = LocalDate.now();
	int day = date.getDayOfMonth(), month = date.getMonthValue(), year = date.getYear();

	public void addDataToDb(int query, String expenseType, double amount, String method) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensedb", "root", "Root1234");
			statement = connection.createStatement();
			if (query == 0) {
				String queryexpense = String.format("INSERT INTO expense values('" + expenseType + "','" + amount
						+ "','" + date + "','" + method + "','" + day + "','" + month + "','" + year + "')");
				statement.executeUpdate(queryexpense);
			} else {
				String queryeincome = String.format("INSERT INTO income values('" + expenseType + "','" + amount + "','"
						+ date + "','" + method + "','" + day + "','" + month + "','" + year + "')");
				statement.executeUpdate(queryeincome);
			}
			System.out.println("Success...");
			return;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ResultSet searchTransactionDb(int value,int year ) {
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensedb", "root", "Root1234");
			statement = connection.createStatement();
			if (value == 2) {
				System.out.println("\t\t\t***** You are Searching For Expense *****");
				String sql = String.format("Select * from expense where year='" +year+ "' ");
				resultSet= statement.executeQuery(sql);
				return resultSet;
			} 
			else if(value==1){
				System.out.println("\t\t\t***** You are Searching For Income *****");
				System.out.println("income");
				String sql = String.format("Select * from income where year='" +year+ "' ");
				resultSet= statement.executeQuery(sql); 
				return resultSet;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}

	public ResultSet searchTransactionDb(int value,int month,int year ) {
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensedb", "root", "Root1234");
			statement = connection.createStatement();
			if (value == 2) {
				//System.out.println("\t\t\t***** You are Searching For Expense *****");
				String sql = String.format("Select * from expense where month='"+month+"'AND year='"+year+"'");
				resultSet= statement.executeQuery(sql);
				return resultSet;
			} 
			else if(value==1){
				//System.out.println("\t\t\tYou are Searching For Income");
				String sql = String.format("Select * from income where month='"+month+"'AND year='"+year+"'" );
				resultSet= statement.executeQuery(sql);
				return resultSet;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}

	public ResultSet searchTransactionDb(int value,int date,int month,int year ) {
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensedb", "root", "Root1234");
			statement = connection.createStatement();
			if (value == 2) {
				System.out.println("\t\t\t***** You are Searching For Expense *****");
				String sql = String.format("Select * from expense where day='"+date+"'AND month='"+month+"'AND year='"+year+"'");
				resultSet= statement.executeQuery(sql);
				return resultSet;
			} else if(value==1)
			{
				System.out.println("\t\t\t***** You are Searching For Income *****");
				String sql = String.format("Select * from income where day='"+date+"'AND month='"+month+"'AND year='"+year+"'");
				resultSet= statement.executeQuery(sql);
				return resultSet;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}
}
