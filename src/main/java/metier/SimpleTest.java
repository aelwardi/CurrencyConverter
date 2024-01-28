package metier;

import java.util.List;

public class SimpleTest {

	public static void main(String[] args) {
		IExchanger exchanger = new ExchangeDevice();
		List<CurrencyByUS> byUSs = exchanger.getxchanges();
		
		for(CurrencyByUS currencyByUS: byUSs) {
			System.out.println("Devise: " +  currencyByUS.getCurrency() + ", Taux: " + currencyByUS.getExchangeByUs());;
		}

	}

}
