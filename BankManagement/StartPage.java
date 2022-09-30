package bankapplication;

import java.util.Scanner;

public class StartPage {
	int input;
	Scanner sc=new Scanner(System.in);
	BankProcess bo=new BankProcess();
	public void startMethod()
	{
		System.out.println(" Yes Bank");
		System.out.println("----------------");
		System.out.println("1.Already User");
		System.out.println("2.New User");
		System.out.println("Enter the option: ");
		input=sc.nextInt();
		if(input>0&&input<3)
		{
			switch(input)
			{
				case 1:	bo.alreadyUser();startMethod();break;
				case 2: bo.newUser();startMethod();break;
			}
		}else {
			System.out.println("!Invalid Key");
		}
		
	}
}
