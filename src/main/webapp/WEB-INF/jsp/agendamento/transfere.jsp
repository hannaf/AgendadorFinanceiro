<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Agendar Transferência</h1>

	<form method="post" action="${linkTo[AgendamentoController].confirma}">
		<ul>
			<li><label for="contaOrigem">Conta de Origem</label>
				<input type="text" name="transferencia.contaOrigem" maxlength="7">
			</li>
			<li><label for="contaDestino">Conta Destino</label>
				<input type="text" name="transferencia.contaOrigem" maxlength="7">
			</li>
			<li><label for="valor">Valor</label>
				<input type="text" name="transferencia.valor" maxlength="18">
			</li>
			<li><label for="taxa">Taxa</label>
				<input type="text" name="transferencia.taxa" disabled="disabled" maxlength="18">
			</li>
			<li><label for="data">Data da Transferência</label>
				<input type="text" name="transferencia.dataAgendamento" maxlength="10">
			</li>
			<li><label for="">Tipo</label> 
				<select name="transferencia.tipo">
					<c:forEach items="${tiposLista}" var="tipo">
						<option value="${tipo.id}">${tipo.nome}</option>
					</c:forEach>
				</select>
			</li>
		</ul>
		<input type="submit" value="Confirmar">
	</form>

</body>
</html>