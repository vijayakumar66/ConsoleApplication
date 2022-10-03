package view;

import controler.TransActionController;

public class TransactionView {
	TransActionController transActionController = new TransActionController();

	public void trannsactionView(long userid) {
		transActionController.transactionView(userid);
	}

}
