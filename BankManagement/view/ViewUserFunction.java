package view;

import java.util.Scanner;

import controler.BalanceController;

public class ViewUserFunction {
	int input;
	Scanner scanner = new Scanner(System.in);

	public void viewUser(long userid) {
		BalanceController balanceController = new BalanceController();
		MoneyTransfer moneyTransfer = new MoneyTransfer();
		AddMoney addMoney = new AddMoney();
		TransactionView transactionView = new TransactionView();
		UserInfoView UserInfoView = new UserInfoView();
		System.out.println("\t******User Services****");
		System.out.println("\t1.View account info");
		System.out.println("\t2.Money transfer");
		System.out.println("\t3.Transaction");
		System.out.println("\t4.Add money");
		System.out.println("\t5.Show balance");
		System.out.println("\t6.Logout");
		System.out.println("----------------------");
		System.out.println("Enter the key");
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid Key.Enter again :");
			scanner.nextLine();
		}
		input = scanner.nextInt();
		if (input > 0 && input < 7) {
			switch (input) {
			case 1:
				UserInfoView.userInfoView(userid);
				;
				viewUser(userid);
				break;
			case 2:
				moneyTransfer.moneytransfer(userid);
				viewUser(userid);
				break;
			case 3:
				transactionView.trannsactionView(userid);
				viewUser(userid);
				break;
			case 4:
				addMoney.addMoney(userid);
				viewUser(userid);
				break;
			case 5:
				balanceController.showBalanceview(userid);
				viewUser(userid);
				break;
			case 6:
				System.out.println("Hava nice day...");
				System.exit(0);
				break;

			}
		} else {
			System.out.println("------------------");
			System.out.println("!Invalid key");
			viewUser(userid);
		}

	}
}
