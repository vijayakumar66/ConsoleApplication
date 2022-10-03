package controler;

import java.sql.ResultSet;

public class UserInfoController {
	DatabaseController databaseController = new DatabaseController();

	public void viewUserInfo(long userId) {
		ResultSet resultSet = databaseController.viewInfromation(userId);
		try {
			while (resultSet.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("Name:" + resultSet.getString(2));
				System.out.println("UserId:" + resultSet.getLong(1));
				System.out.println("Mobile:" + resultSet.getLong(3));
				System.out.println("AccountNumber:" + resultSet.getLong(4));
				System.out.println("Age:" + resultSet.getInt(6));
				System.out.println("Password:" + resultSet.getString(5));
				System.out.println("------------------------------------------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
