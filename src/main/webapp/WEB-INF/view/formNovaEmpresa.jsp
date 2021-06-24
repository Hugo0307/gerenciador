<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrando o nome da Empresa!</title>
</head>
<c:import url="logout-parcial.jsp"></c:import>
<body>
	<form action="${linkEntradaServlet}" method="POST">
		<h1>Cadastre o nome de sua empresa!</h1>
		Nome: <input type="text" name="nome" /> Data de Abertura: <input
			type="text" name="data" /> <input type="hidden" name="acao"
			value="NovaEmpresa" /> <input type="submit" />
	</form>
</body>
</html>