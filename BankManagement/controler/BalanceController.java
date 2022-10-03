package controler;

import java.sql.ResultSet;

import model.TransactionModel;

public class BalanceController {
	DatabaseController databaseController = new DatabaseController();
	private long creditAmount, debitamount;
	private double balance;
	TransactionModel transactionModel = new TransactionModel();

	public void showBalanceview(long userid) {

		balance = cheackBalance(userid);
		System.out.println("**************************");
		System.out.println("Your Balance is Rs." + balance);
		System.out.println();
		System.out.println("**************************");
	}

	public double cheackBalance(long userid) {
		ResultSet resultSet = databaseController.showBalanceView(userid);
		try {
			while (resultSet.next()) {
				creditAmount += resultSet.getDouble(1);
				debitamount += resultSet.getDouble(2);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		balance = (creditAmount - debitamount);
		return balance;
	}

}
