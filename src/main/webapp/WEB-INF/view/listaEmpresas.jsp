<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"></c:import>
	<c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
    </c:if>
	Usuário logado: <strong>${usuarioLogado.login }</strong>		
<br/>
<br/>
	Lista de empresas:
	<br />

	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>${empresa.nome } - <fmt:formatDate
					value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" /> <div><a
				href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a> <a
				href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a></div>
			</li>
		</c:forEach>
	</ul>
	<br/><a href="/gerenciador/entrada?acao=NovaEmpresaForm"><button>Adicionar nova empresa</button></a>
</body>
</html>