package metier;

public class CurrencyByUS {
	private String currency;
	private double exchangeByUs;
	
	// Cunstroctors
	public CurrencyByUS() {
		super();
	}
	public CurrencyByUS(String currency, double exchangeByUs) {
		super();
		this.currency = currency;
		this.exchangeByUs = exchangeByUs;
	}
	
	// Setters & Getters
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getExchangeByUs() {
		return exchangeByUs;
	}
	public void setExchangeByUs(double exchangeByUs) {
		this.exchangeByUs = exchangeByUs;
	}
	

}
