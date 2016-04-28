<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				
				<table width="100%" border="1" cellspacing="0" cellpadding="5">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Sexo</th>
							<th>CPF</th>
							<th>Dt. Nasc.</th>
							<th>Endereço</th>
							<th>Cidade</th>
							<th>UF</th>
							<th colspan="3">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaPessoas}" var="pessoa">
							<tr>
								<td class="alignCenter">${pessoa.idPessoa}</td>
								<td class="alignLeft">${pessoa.nome}</td>
								<td class="alignCenter">${pessoa.sexo}</td>
								<td class="alignCenter">${pessoa.cpf}</td>
								<td class="alignCenter">${pessoa.dtNasc}</td>
								<td class="alignLeft">${pessoa.endereco.logradouro}</td>
								<td class="alignLeft">${pessoa.endereco.cidade.descricao}</td>
								<td class="alignLeft">${pessoa.endereco.cidade.uf.descricao}</td>
								<td class="alignCenter">
									<c:forEach items="${pessoa.preferencias}" var="p" varStatus="status">
										<c:set var="preferencias" value="${status.first ? ' ' : preferencias} [${p.descricao}]" />
									</c:forEach>
									<a href="javascript:void(0)" title="Preferências" onclick="alert('${preferencias}');">
										<img alt="Preferências" src="img/preference.png"/>
									</a>
								</td>
								<td class="alignCenter">
									<a href="main?acao=editarPessoa&id_pessoa=${pessoa.idPessoa}" title="Editar">
										<img alt="Edição de Pessoa" src="img/edit.png"/>
									</a>
								</td>
								<td class="alignCenter">
									<a href="main?acao=removerPessoa&id_pessoa=${pessoa.idPessoa}" title="Deletar">
										<img alt="Remoção de Pessoa" src="img/delete.png"/>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
	
	<jsp:include page="rodape.jsp"/>

</body>
</html>