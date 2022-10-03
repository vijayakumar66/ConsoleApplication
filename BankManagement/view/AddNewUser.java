package view;

import java.util.Scanner;

import controler.UserDataController;
import model.UserModel;

public class AddNewUser {
	UserDataController userDataController = new UserDataController();
	UserModel userModel = new UserModel();
	Scanner s = new Scanner(System.in);
	static long userid = 12146, accountnumber = 321235;

	public void newUser() {
		System.out.println("Resgister Your details...");
		System.out.println("Enter your name ");
		userModel.setUserName(s.next());
		System.out.println("Enter your mobile ");
		userModel.setMobile(s.nextLong());
		System.out.println("Enter your password ");
		userModel.setUserPassword(s.next());
		System.out.println("Enter your age ");
		userModel.setAge(s.nextInt());
		System.out.println("Enter the E-mail");
		userModel.setEmail(s.next());
		userModel.setAccountNumber(accountnumber);
		userModel.setUserId(userid);
		userDataController.insertData(userModel.getUserId() + 1, userModel.getUserName(), userModel.getMobile(),
				userModel.getAccountNumber() + 1, userModel.getAge(), userModel.getUserPassword(),
				userModel.getEmail());
		System.out.print("\t******Your UserId \t    ");
		System.out.print(userid + 1 + "   *******");
		System.out.println();
		System.out.print("\t*****Your Account Number   ");
		System.out.print(accountnumber + 1 + "   *******");
		System.out.println();
		System.out.println("\t--------------------------------------");
		userid = userModel.getUserId() + 3;
		accountnumber = userModel.getAccountNumber() + 3;
		return;
	}
}
