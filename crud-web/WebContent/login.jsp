<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login - Devmedia CRUD Web</title>
	<link rel="stylesheet" href="css/global.css"/>
</head>
<body>
	<form method="post" id="login_form">
		<fieldset id="fieldset_login">
			<legend>Login do Sistema</legend>
		
			<div class="campo">
				<label for="login"></label>
				<input type="text" id="login" name="login" maxlength="15"/>
			</div>
			
			<div class="campo">
				<label for="senha"></label>
				<input type="password" id="senha" name="senha" maxlength="15"/>
			</div>
			
			<div class="campo">
				<input type="submit" value="Logar"/>
			</div>
		</fieldset>
	</form>
</body>
</html>