package controler;

public class UserDataController {
	DatabaseController databaseController = new DatabaseController();
	boolean isTrue;

	public void insertData(long userid, String username, long mobile, long accountnumber, int age, String password,
			String email) {
		isTrue = databaseController.insertNewUser(userid, username, mobile, accountnumber, age, password, email);
		if (isTrue == true) {
			System.out.println("User details added Success.....");
		} else {
			System.out.println("Incorrect User/Password");
		}
	}

}
