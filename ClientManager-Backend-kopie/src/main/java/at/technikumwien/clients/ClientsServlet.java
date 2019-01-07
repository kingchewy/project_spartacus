package at.technikumwien.clients;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/clientsservlet")
@SuppressWarnings("serial")
public class ClientsServlet extends HttpServlet {
	@Inject
	private ClientsService clientsService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		StringBuilder html = new StringBuilder(
			"<!DOCTYPE html>" +
			"<html>" +
			"<head>" +
			"<meta charset='UTF-8'>" +
			"<title>Clients</title>" +
			"</head>" +
			"<body>" +
			"<h1>News</h1>"
		);
		
		List<Clients> clientsList = clientsService.getAllClients();
		
		for (Clients clients : clientsList) {
			html.append(
				"<h2>" + clients.getName() + "</h2>" +
				"<p>" + clients.getText() + "</p>"
			);
		}
		
		html.append(
			"</body>" +
			"</html>"
		);
		
		out.println(html.toString());
	}
}