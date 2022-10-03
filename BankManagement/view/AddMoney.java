package view;

import java.util.Scanner;
import controler.AddMoneyController;

public class AddMoney {
	int input;
	long accountnumber;
	double amount;
	ViewUserFunction viewUserFunction = new ViewUserFunction();
	AddMoneyController addMoneyController = new AddMoneyController();
	Scanner scanner = new Scanner(System.in);

	public void addMoney(long userid) {
		System.out.println("Enter the Account number");
		accountnumber = scanner.nextLong();
		System.out.println("Enter the amount");
		amount = scanner.nextDouble();
		System.out.println("---------------------");
		System.out.println("select option");
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
				addMoneyController.addMoneyDb(userid, amount);
				viewUserFunction.viewUser(userid);
				break;
			case 2:
				viewUserFunction.viewUser(userid);
				break;
			}
		}

	}

}
