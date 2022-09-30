package personal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

interface Functions {
	public void addExpense();
	public void addIncome();
	public void viewTranction();
	public void updateBalance();
	public void updateBalanceIncome();
	public void updateBalanceExpense();
	
}
class  FunctionsMethods implements Functions 
{
	private double totalIncome,totalExpense,balance;
	double input_Amount;
	int input;
	boolean correct=true;
	PojoPerson pp=new PojoPerson();
	ArrayList<String> incometype=new ArrayList<>();
	ArrayList<Double> income=new ArrayList<>();
	ArrayList<String> expensetype=new ArrayList<>();
	ArrayList<Double> expense=new ArrayList<>();
	
	Scanner sc=new Scanner(System.in);
	@Override
	public void addExpense() {
		System.out.println("Select the Expense Type: ");
		System.out.println("1.Education ");
		System.out.println("2.Food ");
		System.out.println("3.Travel ");
		System.out.println("4.Entertainment ");
		System.out.println("5.Rent ");
		System.out.println("6.Internet Bills ");
		System.out.println("7.Medical ");
		System.out.println("8.Others ");
		System.out.println("Select the key: ");
		try
		{
			input=sc.nextInt();
			if(input>0&&input<9)
			{
				switch(input)
				{
					
					case 1:pp.setExpense_Type("Education");break;
					case 2:pp.setExpense_Type("Food");break;
					case 3:pp.setExpense_Type("Travel");break;
					case 4:pp.setExpense_Type("Education");break;
					case 5:pp.setExpense_Type("Entertainment");break;
					case 6:pp.setExpense_Type("Rent");break;
					case 7:pp.setExpense_Type("Medical");break;
					case 8:pp.setExpense_Type("Others");break;	
					//default :System.out.println("Invalid Option");addExpense();break;
				}	
			}
			else {
				System.out.println("---------------------");
				System.out.println("Invalid key");
				addExpense();
			}
		}catch(Exception e){
			System.out.println("Invalid key");
		}
		
			System.out.println("Enter the Amount");
			try {
				
				input_Amount=sc.nextInt();
				if(input_Amount>0)
				{
					pp.setExpense(input_Amount);
					expense.add(input_Amount);
					expensetype.add(pp.getExpense_Type());
					System.out.println("Succuess..");
					updateBalanceExpense();
				}
				else
				{
					System.out.println("---------------------");
					System.out.println("Invalid Amount");
					addExpense();
				}
			}catch(Exception e)
			{	
				System.out.println("Invalid Amount");
			}
		
		return ;
	}

	@Override
	public void addIncome() {
		
		System.out.println("Enter the Income: ");
		System.out.println("1.salary ");
		System.out.println("2.profit ");
		System.out.println("3.others ");
		System.out.println("Enter the key ");
		try
		{
			input=sc.nextInt();
			if(input>0&&input<4)
			{
				switch(input)
				{	
					case 1:pp.setIncome_Type("salary");break;
					case 2:pp.setIncome_Type("Profit");break;
					case 3:pp.setIncome_Type("Others");break;
					//default :System.out.println("Invalid Option");addIncome();break;
				}
			}else {
				System.out.println("Invalid Key");
				System.out.println("-------------------");
				addIncome();
			}
			
		}catch(Exception e){
			System.out.println("Invalid key");
		}
		
	
			try {
				System.out.println("Enter the Amount");
					input_Amount=sc.nextInt();
					if(input_Amount>0)
					{
						pp.setIncome(input_Amount);
						income.add(input_Amount);
						incometype.add(pp.getIncome_Type());
						updateBalanceIncome();
						System.out.println("Succuess..");
					}
					else {
						System.out.println("Invalid Amount");
						System.out.println("-------------------");
						addIncome();
					}
			}catch(Exception e)
			{
				System.out.println("Please Enter the valid Amount");
			}
		return ;
	}
	
	@Override
	public void viewTranction() {
		//updateBalance();
		System.out.println("-------------------------------------");
		System.out.println("\t  Tranaction Details ");
		System.out.println("Total incomes \t\t Rs."+totalIncome);
		for(int i=0;i<income.size();i++)
		{
			System.out.printf("%-28s%.1f\n",incometype.get(i),income.get(i));
		}
		
		System.out.println("Total Expenses\t\t Rs."+totalExpense);
		for(int i=0;i<expense.size();i++)
		{
			System.out.printf("%-28s%.1f\n",expensetype.get(i),expense.get(i));
		}
		System.out.println("-------------------------------------");
		System.out.println("Current Balance\t\t Rs."+balance);
		System.out.println("-------------------------------------");
		return;
	
	}

	@Override
	public void updateBalanceIncome() {
		totalIncome+=pp.getIncome();	
		balance=totalIncome-totalExpense;
		
	}
	public void updateBalanceExpense() {	
		totalExpense+=pp.getExpense();
		balance=totalIncome-totalExpense;
		
	}
	public void updateBalance() {	
		balance=totalIncome-totalExpense;
		
	}
	public void InsertIntoDb() throws SQLException
	{
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Root1234");  
		Statement statement = connection.createStatement();
		
	}
}