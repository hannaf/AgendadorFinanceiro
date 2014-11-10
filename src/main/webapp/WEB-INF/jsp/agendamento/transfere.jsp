<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script type="text/javascript" src="../resources/js/jquery-2.1.1.min.js"></script>
</head>
<body>



	<h1>Agendar Transferência</h1>

	<c:forEach items="${errors}" var="error">
		<li>${error.category}:${error.message}</li>
	</c:forEach>

	<form method="post" action="${linkTo[AgendamentoController].confirma}">
		<ul>
			<li><label for="contaOrigem">Conta de Origem</label> <input
				type="text" name="transferencia.contaOrigem" maxlength="7">
			</li>
			<li><label for="contaDestino">Conta Destino</label> <input
				type="text" name="transferencia.contaDestino" maxlength="7">
			</li>
			<li><label for="valor">Valor</label> <input type="text"
				name="transferencia.valor" maxlength="18"></li>
			<li><label for="taxa">Taxa</label> <input type="text"
				name="transferencia.taxa" disabled="disabled" maxlength="18">
			</li>
			<li><label for="data">Data da Transferência</label> <input
				type="text" name="transferencia.dataAgendamento" maxlength="10">
			</li>
			<li><label for="">Tipo</label> <select name="transferencia.tipo">
					<option>Selecione</option>
					<c:forEach items="${tiposLista}" var="tipo">
						<option value="${tipo.id}">${tipo.nome}</option>
					</c:forEach>
			</select></li>
		</ul>
		<input type="submit" value="Confirmar">
	</form>


	<table>
		<thead>
			<tr>
				<td>Conta Destino</td>
				<td>Valor</td>
				<td>Data Agendada</td>
				<td>Tipo</td>
				<td>Taxa</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transferencias}" var="transferencia">
				<tr>
					<td>${transferencia.contaDestino}</td>
					<td>${transferencia.valor}</td>
					<td>${transferencia.dataAgendamento}</td>
					<td>${transferencia.tipo}</td>
					<td>${transferencia.taxa}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
		$(document).ready(function() {
			alert("jQuery");
		});
	</script>

</body>
</html>