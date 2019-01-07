package nightfight.accounts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
@SuppressWarnings("serial")
public class AccountsServlet extends HttpServlet {
	
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
			"<h1>Accounts</h1>"
		);
				
		html.append(
			"</body>" +
			"</html>"
		);
		
		out.println(html.toString());
	}
}
