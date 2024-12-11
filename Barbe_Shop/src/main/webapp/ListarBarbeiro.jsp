<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type="text/css" href="css/Teste.css">
</head>
<body>

<body>

	<br>

	<br>

	<h1>LOGIN</h1>

	<br>

	<br>

	<form name="LOGIN" action="LoginController" method="GET">

		<table>

			<tr>

				<td>Nome</td>

				<td><input type="hidden" name="acao" value="LOGAR" /></td>

				<td><input type="text" name="nome" size="10"
					maxlength="10" /></td>
					<td>Senha</td>
					<td><input type="text" name="senha" size="10"
					maxlength="10" /></td>

				<td><input type="submit" value="Buscar" /></td>

			</tr>

		</table>

	</form>

	


</body>
</html>