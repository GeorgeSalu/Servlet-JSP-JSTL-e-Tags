<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expression Language</title>
</head>
<body>
	
	<%
		request.setAttribute("nome", "Diogo Souza");
		session.setAttribute("nome", "R Teste");
		application.setAttribute("versao", "1.0");
	%>

	Nome é: ${nome} <br/>
	Endereço é: ${endereco} <br/>
	Version é: ${versao} <br/>
</body>
</html>