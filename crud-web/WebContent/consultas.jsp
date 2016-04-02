<%@page import="br.edu.devmedia.crud.dto.PessoaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultas</title>
<link rel="stylesheet" href="css/global.css"/>
</head>
<body>

	<jsp:include page="cabecalho.jsp"/>
	
	<div class="main">
		<form action="">
			<jsp:include page="msg.jsp"/>
			
			<fieldset>
				<legend>Consultas</legend> 
				<h1>Consultas</h1>
				
				<table>
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Sexo</th>
							<th>Dt. Nasc.</th>
						</tr>
					</thead>
					<tbody>
					<%
						List<PessoaDTO> listaPessoas = (List<PessoaDTO>) request.getAttribute("listaPessoas");
						for (PessoaDTO pessoa : listaPessoas) {
					%>
						<tr>
							<td><%= pessoa.getIdPessoa() %></td>
							<td><%= pessoa.getNome() %></td>
							<td><%= pessoa.getSexo() %></td>
							<td><%= pessoa.getDtNasc() %></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
	
	<jsp:include page="rodape.jsp"/>

</body>
</html>