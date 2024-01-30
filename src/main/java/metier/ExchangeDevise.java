package metier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class ExchangeDevise implements IExchanger {
	
	public List<CurrencyByUS> getxchanges() {
		// Une liste pour qu'on puisse enregister les taux de change par US de base
		List<CurrencyByUS> list = new ArrayList<CurrencyByUS>();
		try {
			// URL du fichier json basé sur US
			String USCurrency = "https://openexchangerates.org/api/latest.json?app_id=9976e8fe6d99484cb3113c7714aff5a3";
			
			// Ouvertir de la connexion vers l'URL
			URL url = new URL(USCurrency);
			
			// Création d'un BufferReader pour lire les données à partir de la connexion
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
			
			// StringBuilder pour stocker les données lues
			StringBuilder stringBuilder = new StringBuilder();
			String ligne;
			
			// Lire les données ligne par ligne et ajouter au StringBuolder
			while ((ligne = reader.readLine()) != null) {
				stringBuilder.append(ligne);
			}
			
			// Fermeture de BufferedReader
			reader.close();
			
			// Convertir les données JSON en chaine de caractères
			String jsonString = stringBuilder.toString();
			
			// Convertir de la chaine JSON  en objet JSONObject
			JSONObject jsonObject = new JSONObject(jsonString);
			
			// En accédant au JSONObject "rates"
			JSONObject ratesObject = jsonObject.getJSONObject("rates");
			
			// Parcourir les paires clé-valeur du JSONObject "rates"
			for(String currency: ratesObject.keySet()) {
				double exchangeByUs = ratesObject.getDouble(currency);
				CurrencyByUS currencyByUS = new CurrencyByUS(currency, exchangeByUs);
				list.add(currencyByUS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public double getExchangeCurrency(double fromCurrency, double toCurrency, double amount) {
		try {
			if(fromCurrency != toCurrency) {
				amount = amount * (toCurrency / fromCurrency);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}
	
	private void init() {
		System.out.println("Initialization ......");
	}

}
