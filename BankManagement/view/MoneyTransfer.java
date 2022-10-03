package view;

import java.util.Scanner;
import controler.MoneyTransferController;
import model.UserModel;

public class MoneyTransfer {
	int input;
	long accountnumber1, accountnumber;
	double transferAmount;
	UserModel userModel = new UserModel();
	MoneyTransferController moneyTransferController = new MoneyTransferController();
	Scanner scanner = new Scanner(System.in);

	void moneytransfer(long userid) {
		System.out.println("Enter the To Account number:");
		accountnumber = scanner.nextLong();
		System.out.println("Re-enter the Account number:");
		accountnumber1 = scanner.nextLong();
		if (accountnumber1 != accountnumber) {
			System.out.println("!Account Number Not Match!");
			moneytransfer(userid);
		}
		System.out.println("Enter the IFSCCode:");
		String ifsccod = scanner.next();
		System.out.println("Enter the amount:");
		transferAmount = scanner.nextDouble();
		System.out.println("---------------------");
		System.out.println("select option:");
		System.out.println("1.Confirm");
		System.out.println("2.Cancel");
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid Key.Enter again :");
			scanner.nextLine();
		}
		input = scanner.nextInt();
		if (input < 3 && input > 0) {
			switch (input) {
			case 1:
				moneyTransferController.transferMoney(userid, transferAmount);
				break;
			case 2:
				return;
			}
		}
	}
}
