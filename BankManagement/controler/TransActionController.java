package controler;

import model.TransactionModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransActionController {
	DatabaseController databaseController = new DatabaseController();
	TransactionModel transactionModel = new TransactionModel();
	private long creditAmount, debitamount, balance;

	public void transactionView(long userid) {
		try {
			ResultSet resultSet = databaseController.transactionView(userid);
			System.out.println(
					"************************************************************************************************");
			System.out.print("UserId\t    \tCreditAmount     \tDebitAmount     \tDate      \tCredit/Debit\n");
			System.out.println(
					"------------------------------------------------------------------------------------------------");
			System.out.println();
			while (resultSet.next()) {
				System.out.print("" + resultSet.getLong(1));
				System.out.print("\t\t" + resultSet.getDouble(2));
				System.out.print("\t\t\t" + resultSet.getDouble(3));
				System.out.print("\t\t\t" + resultSet.getString(4));
				System.out.print("\t   " + resultSet.getString(5));
				System.out.println();
				creditAmount += resultSet.getDouble(2);
				debitamount += resultSet.getDouble(3);
			}
			System.out.println(
					"------------------------------------------------------------------------------------------------");
			System.out.print("\t RS" + creditAmount + "\t\t   Rs." + debitamount);
			System.out.println(
					"\n************************************************************************************************");
			transactionModel.setCreditAmout(creditAmount);
			transactionModel.setDebitAmount(debitamount);
			balance = creditAmount - debitamount;
			transactionModel.setBalance(balance);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}