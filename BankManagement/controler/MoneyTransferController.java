package controler;

public class MoneyTransferController {
	DatabaseController databaseController = new DatabaseController();
	BalanceController balanceController = new BalanceController();
	double balance;

	public void transferMoney(long userid, double amount) {
		balance = balanceController.cheackBalance(userid);
		if (balance > amount) {
			databaseController.moneyTransfer(userid, amount);
			System.out.println("Money Transfer is Succesfull.");
		} else {
			System.out.println("Your balance less than transfer Amount");
		}

	}

}
