package bankapplication;

import java.util.Scanner;

public class BankProcess {
	int input;
	long accountnumber1,accountnumber;
	double amount;
	boolean login=false;
	Scanner s = new Scanner(System.in);
	UserDetails user = new UserDetails();
	DatabaseConnection db = new DatabaseConnection();
	void newUser() {
		System.out.println("Resgister Your details...");
		System.out.println("Enter your name: ");
		user.setUserName(s.next());
		System.out.println("Enter your userid: ");
		user.setUserId(s.nextInt());
		System.out.println("Enter your accountnumber: ");
		user.setAccountNumber(s.nextInt());
		System.out.println("Enter your mobile: ");
		user.setMobile(s.nextLong());
		System.out.println("Enter your password: ");
		user.setUserPassword(s.next());
		System.out.println("Enter your age: ");
		user.setAge(s.nextInt());
		db.insertData(user.getUserId(), user.getUserName(), user.getMobile(), user.getAge(), user.getAccountNumber(),
		user.getUserPassword());
		return ;
	}
	public void alreadyUser()
	{
		System.out.println("Enter the userid:");
		user.setUserId(s.nextInt());
		System.out.println("Enter the password: ");
		String password=s.next();
		login=db.userLogin(user.getUserId(), password);
		if(login)
			viewUser();
	}
	private void viewUser()
	{
		
		System.out.println("1.view account info");
		System.out.println("2.money transfer");
		System.out.println("3.transaction");
		System.out.println("4.add money");
		System.out.println("5.logout");
		System.out.println("<---------------------->");
		System.out.println("Enter the key");
		input=s.nextInt();
		if(input>0&&input<5)
		{
			switch(input)
			{
				case 1:viewInfo();break;
				case 2:moneytransfer();break;
				case 3:transaction();break;
				case 4:addMoney();break;
				case 5:logOut();break;
				
			}
		}else {
			System.out.println("------------------");
			System.out.println("!Invalid key");
			viewUser();
		}
		
	}
	private void addMoney() {
		System.out.println("Enter the To Account number:");
		 accountnumber=s.nextLong();
		System.out.println("Enter the amount:");
		amount=s.nextDouble();
		user.setBalance(amount);
		System.out.println("---------------------");
		System.out.println("select option:");
		System.out.println("1.Confirm");
		System.out.println("2.Cancel");
		input=s.nextInt();
		if(input<3&&input>0)
		{
			switch(input)
			{
				case 1:db.deposit(user.getUserId(),amount,accountnumber);
						viewUser();break;
				case 2:viewUser();break;
			}
		}
		
	}
	private void transaction() {
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("userid\t\tcredit\t\tdebit\t\tdate\t\tbalance\t\t    status\t\t   from");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		db.transactionView(user.getUserId());
	}
	private void logOut() {
		System.out.println("Thank you using ):");
		System.exit(0);
	}
	private void moneytransfer() {
		
		System.out.println("Enter the To Account number:");
		 accountnumber=s.nextLong();
		System.out.println("Re-enter the Account number:");
		 accountnumber1=s.nextLong();
		if(accountnumber1!=accountnumber)
		{
			System.out.println("!Account Number Not Match!");
			moneytransfer();
		}
		System.out.println("Enter the amount:");
		amount=s.nextDouble();
		System.out.println("---------------------");
		System.out.println("select option:");
		System.out.println("1.Confirm");
		System.out.println("2.Cancel");
		input=s.nextInt();
		if(input<3&&input>0)
		{
			switch(input)
			{
				case 1:db.transfermoney(user.getUserId(),amount,accountnumber);
						viewUser();break;
				case 2:viewUser();break;
			}
		}
		
		
	}
	private void viewInfo() {
		db.viewinfo(user.getUserId());
		viewUser();
	}

}
