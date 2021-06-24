<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrando o nome da Empresa!</title>
</head>
<body>
	<form action="${linkEntradaServlet}" method="POST">

		<h1>Faça login no sistema!</h1>
		Login:
		<div>
			<input type="text" name="login" /> Senha:<input type="password"
				name="senha" />
		</div>
		<input type="hidden" name="acao" value="Login" /> <input
			type="submit" />
	</form>
</body>
</html>