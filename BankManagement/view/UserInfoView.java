package view;

import java.util.Scanner;

import controler.UserInfoController;
import model.UserModel;

public class UserInfoView {
	UserInfoController UserInfoController = new UserInfoController();
	Scanner s = new Scanner(System.in);
	UserModel userModel = new UserModel();

	public void userInfoView(long userid) {
		UserInfoController.viewUserInfo(userid);
	}

}
