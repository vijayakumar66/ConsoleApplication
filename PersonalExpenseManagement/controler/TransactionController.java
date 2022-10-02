package controler;

import java.sql.ResultSet;

import view.FunctionView;

public class TransactionController {
	DatabaseController databaseController = new DatabaseController();
	//FunctionView functionView=new FunctionView();
	ResultSet resultSet=null;
	  
	public void searchTransaction(int value,int year) {
		resultSet=databaseController.searchTransactionDb(value,year);
		printResultSet(resultSet,value);
	}

	public void searchTransaction(int value, int month,int year) {
		resultSet=databaseController.searchTransactionDb(value,month,year);
		printResultSet(resultSet,value);
	}

	public void searchTransaction(int value, int date,int month,int year) {
		resultSet=databaseController.searchTransactionDb(value,date,month,year);
		printResultSet(resultSet,value);
	}
	public void printResultSet(ResultSet resultSet,int value) {
		
		if(value==2) {
			try {
				System.out.println("***********************************************************************************");
		           System.out.println("ExpenseType\t\tExpenseAmount\tDate\t\tExpensethod");
		           System.out.println("------------------------------------------------------------------------------------------");
		           double totalexpenseAmount = 0;
		           while(resultSet.next()) {
		           String expenseType=resultSet.getString(1);
		           double expenseAmount=resultSet.getDouble(2);
		           String date=resultSet.getString(3);
		           String expenseMethod=resultSet.getString(4);
		           totalexpenseAmount+=expenseAmount;
		           System.out.println();
		           System.out.print(" "+expenseType);
		           System.out.print("\t\t"+expenseAmount);
		           System.out.print("\t\t"+date);
		           System.out.print("\t\t"+expenseMethod);
		           System.out.println();
		        }
				System.out.println("***********************************************************************************");
				System.out.println("\t\t\tTotal Expense Amount Is:RS."+totalexpenseAmount);
				 System.out.println("------------------------------------------------------------------------------------------");
				 Thread.sleep(6000);
			}catch(Exception e)
			{
				System.out.println(e);
			}

		}else {
			try {
				System.out.println("***********************************************************************************");
		           System.out.println("IncomeType\t\tIncomeAmount\tDate\t\tIncomeMethod");
		           System.out.println("------------------------------------------------------------------------------------------");
		           double totalexpenseAmount = 0;
		           while(resultSet.next()) {
		           String incomeType=resultSet.getString(1);
		           double incomeAmount=resultSet.getDouble(2);
		           String date=resultSet.getString(3);
		           String incomeMethod=resultSet.getString(4);
		           totalexpenseAmount+=incomeAmount;
		           System.out.println();
		           System.out.print(" "+incomeType);
		           System.out.print("\t\t"+incomeAmount);
		           System.out.print("\t\t"+date);
		           System.out.print("\t\t"+incomeMethod);
		           System.out.println();
		        }
				System.out.println("***********************************************************************************");
				System.out.println("\t\t\t  Total Income Aomunt Is:RS."+totalexpenseAmount);
				System.out.println("------------------------------------------------------------------------------------------");
				Thread.sleep(6000);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		
	}

}
