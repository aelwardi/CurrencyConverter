package metier;

import java.util.List;

public class SimpleTest {

	public static void main(String[] args) {
		IExchanger exchanger = new ExchangeDevise();
		List<CurrencyByUS> byUSs = exchanger.getxchanges();
		
		for(CurrencyByUS currencyByUS: byUSs) {
			System.out.println("Devise: " +  currencyByUS.getCurrency() + ", Taux: " + currencyByUS.getExchangeByUs());;
		}
		
		// Convertion de Dirham maroc ver Dirham emirates
		System.out.println(exchanger.getExchangeCurrency(9.9715, 3.67295, 200));
	}

}
