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

	<form method="post" action="">
		<ul>
			<li><label for="contaOrigem">Conta de Origem</label>
				<input id="contaOrigem" type="number" name="transferencia.contaOrigem">
			</li>
			<li><label for="contaDestino">Conta Destino</label>
				<input id="contaDestino" type="number" name="transferencia.contaOrigem">
			</li>
			<li><label for="valor">Valor</label>
				<input id="valor" type="number" name="transferencia.valor">
			</li>
			<li><label for="taxa">Taxa</label>
				<input id="taxa" type="number" name="transferencia.taxa">
			</li>
			<li><label for="data">Data da Transferência</label>
				<input id="dataAgendamento" type="date" name="transferencia.dataAgendamento">
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