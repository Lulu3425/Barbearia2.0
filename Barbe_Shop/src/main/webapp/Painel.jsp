<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAINEL</title>
</head>
<body>

	<h1></h1>
	<form name="LOGAR" action="LoginController" method="GET">
		<table style="width: 90%" border="1">
			<thead>
				<tr>
					<td>Nome</td>
					<td colspan="3">Ação</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${listaBarbeiro}" var="barbeiro">
					<tr>
						<td><c:out value="${barbeiro.nome}" /></td>

						
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan='5'><a
						href="ServicosController?acao=AdiconarCorte&id_servicos=<c:out value="${servicos.id}" />">Incluir
							Novo Corte</a></td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>