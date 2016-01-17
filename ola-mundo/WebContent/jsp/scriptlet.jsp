<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scriptlets</title>
</head>
<body>

	<%! int cont = 1; %>
	<p>
	<%
		List<String> nomes = new ArrayList<String>();
		nomes.add("Diogo");
		nomes.add("Sandra");
		nomes.add("Mário");
		nomes.add("Amanda");
		nomes.add("Débora");
		nomes.add("Daniel");
	
		for (String nome : nomes) {
			if (nome.startsWith("D")) {
				if (cont % 2 == 0) {
					out.println("<div style='background-color:none'>" + nome + "</div>");
				} else {
					out.println("<div style='background-color:green'>" + nome + "</div>");
				}
				cont++;
			}
		}
	%>
	</p>
</body>
</html>