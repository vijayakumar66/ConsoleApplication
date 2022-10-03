package model;

public class TransactionModel {
	private double creditAmout,debitAmount;
	private String status;
	private double balance;
	public double getCreditAmout() {
		return creditAmout;
	}
	public void setCreditAmout(double creditAmout) {
		this.creditAmout = creditAmout;
	}
	public double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
