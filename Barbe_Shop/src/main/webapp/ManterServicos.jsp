<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>FAZER SERVICOS</h1>
	<form name="manterServicos" action="ServicosController"
		method="POST">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" readonly="readonly"
					name="id_item_pedido" size="18" maxlength="10"
					value="<c:out value="${servicos.id}" />" /></td>
			</tr>
			
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			
			<tr>
				<td><input type="submit" value="Salvar" /></td>
				<td><input type="button" value="Voltar"
					onclick="history.go(-1)" /></td>

			</tr>
		</table>
	</form>
</body>
</html>