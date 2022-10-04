package view;

import java.util.Scanner;
import controler.IncomeController;
public class IncomeView {
	IncomeController incomeController =new IncomeController();
	Scanner scanner = new Scanner(System.in);
	public void ShowIncomeView() {
		double amount;
		String inputIncome,method;
		System.out.println("Enter the IncomeType: ");
		inputIncome=scanner.next();
		System.out.println("Enter the Amount");
		amount=scanner.nextDouble();
		System.out.println("Enter the Payment Method");
		method=scanner.next();
		incomeController.addIncome(inputIncome,amount,method);
		return ;
	}
}
