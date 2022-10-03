package controler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginController {
	DatabaseController databaseController = new DatabaseController();

	public boolean userLogin(long userid, String ipasssword) {
		ResultSet resultSet = databaseController.loginCheack(userid);
		try {
			while (resultSet.next()) {
				long usr = resultSet.getLong(1);
				String pass = resultSet.getString(2);
				if (userid == usr && ipasssword.equals(pass)) {
					System.out.println("Authendication success..");
					System.out.println("------------------------");
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

}
