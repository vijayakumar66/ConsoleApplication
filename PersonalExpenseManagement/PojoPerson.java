package personal;

public class PojoPerson {

	private double income;
	private double expense;
	private int carryover;
	private String income_Type,expense_Type; 
	public int getCarryover() {
		return carryover;
	}
	public void setCarryover(int carryover) {
		this.carryover = carryover;
	}

	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double input_Amount) {
		this.income = input_Amount;
	}
	public String getExpense_Type() {
		return expense_Type;
	}
	public void setExpense_Type(String expense_Type) {
		this.expense_Type = expense_Type;
	}
	public String getIncome_Type() {
		return income_Type;
	}
	public void setIncome_Type(String income_Type) {
		this.income_Type = income_Type;
	}
	
}
