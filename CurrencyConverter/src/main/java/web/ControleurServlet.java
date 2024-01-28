package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import metier.CurrencyByUS;
import metier.ExchangeDevice;
import metier.IExchanger;

@WebServlet(name = "currency", urlPatterns = "*.php")
public class ControleurServlet extends HttpServlet {
	private IExchanger exchanger;
	
	@Override
	public void init() throws ServletException {
		exchanger = new ExchangeDevice();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if(path.equals("/index.php")) {
			List<CurrencyByUS> list = exchanger.getxchanges();
			list.add(new CurrencyByUS("USD", 1));
			req.setAttribute("model", list);
			req.getRequestDispatcher("views/index.jsp").forward(req, resp);
		}else if(path.equals("/exchange.php")) {
			
		} else {
			resp.sendError(Response.SC_NOT_FOUND);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
