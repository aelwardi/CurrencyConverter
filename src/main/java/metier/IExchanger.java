package metier;

import java.util.List;

public interface IExchanger {
	public List<CurrencyByUS> getxchanges();
	public double getExchangeCurrency(double fromCurrency, double toCurrency, double amount);
}
