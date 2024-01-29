package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import metier.CurrencyByUS;
import metier.ExchangeDevise;
import metier.IExchanger;

@WebServlet(name = "currency", urlPatterns = "*.php")
public class ControleurServlet extends HttpServlet {
	private IExchanger exchanger;
	
	@Override
	public void init() throws ServletException {
		//exchanger = new ExchangeDevise();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		exchanger = (IExchanger) context.getBean("mt");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		ModelCurrency model = new ModelCurrency();
		if(path.equals("/index.php")) {
			List<CurrencyByUS> list = exchanger.getxchanges();
			list.add(new CurrencyByUS("USD", 1));
			model.setList(list);
			req.setAttribute("model", model);
			req.getRequestDispatcher("views/index.jsp").forward(req, resp);
		}else if(path.equals("/exchange.php") && (req.getMethod().equals("POST"))) {
			double fromCurrency = Double.parseDouble(req.getParameter("fromCurrency"));
			double toCurrency = Double.parseDouble(req.getParameter("toCurrency"));
			double amount = Double.parseDouble(req.getParameter("amount"));
			double result = exchanger.getExchangeCurrency(fromCurrency, toCurrency, amount);
			model.setFromCurrency(fromCurrency);
			model.setToCurrency(toCurrency);
			model.setAmount(amount);
			model.setResult(result);
			List<CurrencyByUS> list = exchanger.getxchanges();
			list.add(new CurrencyByUS("USD", 1));
			model.setList(list);
			req.setAttribute("model", model);
			req.getRequestDispatcher("views/index.jsp").forward(req, resp);
		} else {
			resp.sendError(Response.SC_NOT_FOUND);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
