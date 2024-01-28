package web;

public class ModelCurrency {
	//Attributes
	private double fromCurrency;
	private double toCurrency;
	private double Amount;
	private double result;
	
	// Constructors
	public ModelCurrency() {
		super();
	}
	public ModelCurrency(double fromCurrency, double toCurrency, double amount, double result) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		Amount = amount;
		this.result = result;
	}
	
	// Setters & Getters
	public double getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(double fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public double getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(double toCurrency) {
		this.toCurrency = toCurrency;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	

}
