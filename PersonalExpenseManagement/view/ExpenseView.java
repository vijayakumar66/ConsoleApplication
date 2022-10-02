package view;
import java.util.Scanner;
import controler.ExpenseController;
public class ExpenseView {
	ExpenseController expenseController=new ExpenseController();
	Scanner scanner = new Scanner(System.in);
	private String inputExpense,method;
	public void showExpenseList() {
		double amount;
		System.out.println("Enter the ExpeseType");
		inputExpense=scanner.next();
		System.out.println("Enter the Amount");
		amount=scanner.nextDouble();
		System.out.println("Enter the Payment Method");
		method=scanner.next();
		expenseController.addExpense(inputExpense,amount,method);
		return ;
		
	}
}
