package view;

import java.util.Scanner;
import controler.UserLoginController;
import model.UserModel;

public class AlreadyUser {
	UserModel userModel = new UserModel();
	ViewUserFunction viewUserFunction = new ViewUserFunction();
	UserLoginController userLoginController = new UserLoginController();
	Scanner scanner = new Scanner(System.in);
	long userid;

	public void alreadyUser() {
		boolean login;
		System.out.println("Enter the userid:");
		userid = scanner.nextLong();
		System.out.println("Enter the password: ");
		String password = scanner.next();
		login = userLoginController.userLogin(userid, password);
		if (login) {
			viewUserFunction.viewUser(userid);
		} else {
			System.out.println("Incorrect Password/UserId");
			return;
		}

	}

}
