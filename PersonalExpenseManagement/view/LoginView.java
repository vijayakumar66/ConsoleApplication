package view;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;
import controler.LoginController;
public class LoginView {
		LoginController loginControler;
		Scanner scanner=new Scanner(System.in);
		
		LoginView(){
			loginControler = new LoginController();
		}	
		void inital()
		{
			System.out.println("\t\tWelcome Personal Management System");
			System.out.println("\t\t------------------------------------");
			checkLogin();
		}
		public void checkLogin()
		{
			System.out.println("Enter the username");
			String username=scanner.next();
			System.out.println("Enter the password");
			String password=scanner.next();
			if(loginControler.verify(username,password))
			{
				FunctionView functionView=new FunctionView();
				functionView.mainMenu();
			}else {
				System.out.println("Inncorrect Password/UserName");
				checkLogin();
			}
			
		}

		public static void main(String[] args) {
//			LoginView login=new LoginView();
//			login.inital();
			FunctionView functionView=new FunctionView();
			functionView.mainMenu();
			
		}
}
