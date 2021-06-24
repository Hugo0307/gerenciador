<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkEntradaServlet" />
<%-- aqui o value da url tem que ser o mesmo do mapping da webservlet da servlet de alteraEmpresa, só que sem as aspas  --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar os dados da emrpesa!</title>
</head>
<body>
	<form action="${linkEntradaServlet}" method="POST">
		<c:import url="logout-parcial.jsp"></c:import>
		<h2>Altere abaixo os dados da empresa:</h2>

		<br> Nome: <input type="text" name="nome"
			value="${empresa.nome }" /> Data de Abertura: <input type="text"
			name="data"
			value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${empresa.id }" />
		<input type="hidden" name="acao" value="AlteraEmpresa" />
		<input type="submit" />
	</form>
</body>
</html>