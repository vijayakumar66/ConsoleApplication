package controler;

public class AddMoneyController {
	DatabaseController databaseController = new DatabaseController();

	public void addMoneyDb(long userid, double amount) {
		databaseController.addMoney(userid, amount);
		System.out.println("Money added success...");

	}
}
