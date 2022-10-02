package model;

public class BalanceTransaction {
	private double totalIncome;
	private double totalBalance;
	private double balance;
	private double carryOver;
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getCarryOver() {
		return carryOver;
	}
	public void setCarryOver(double carryOver) {
		this.carryOver = carryOver;
	}

}
