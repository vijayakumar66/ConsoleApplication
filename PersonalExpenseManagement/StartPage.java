package personal;

import java.util.Scanner;

class StartPage {
	Scanner sc=new Scanner(System.in);
	private int option;
	FunctionsMethods fn=new FunctionsMethods();
	public void getOption()
	{
		
		
		try
		{	
			do {
				System.out.println("----------------------------");
				System.out.println("PERSONAL EXPENSE MANAGEMENT");
				System.out.println("----------------------------");
				System.out.println("1.ADD EXPENSE");
				System.out.println("2.ADD INCOME ");
				System.out.println("3.VIEW TRANSACTION");
				System.out.println("4.Exit");
				System.out.println("----------------------------");
				System.out.println("Enter the options: ");
			option=sc.nextInt();
			
			switch(option) {
			case 1:fn.addExpense();break;
			case 2:fn.addIncome();break;
			case 3:fn.viewTranction();break;
			case 4:System.out.println("Thank You Using");break;
			default:System.out.println("Enter the valid key!");
				}
			}while(option!=4);
			
		}
		catch(Exception e)
		{
			System.out.println("Please Enter the valid key!");
		}
	}
}
