<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Agendar Transferencia</title>
<script type="text/javascript"
	src="<c:url value="resources/js/jquery-2.1.1.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.mask.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/css/style.css"/>">

</head>
<body>

	<div class="principal">

		<section class="formulario">

			<h2>Agendar Transferência</h2>

			<div class="erro">
				<c:forEach items="${errors}" var="error">
					<li>${error.message}</li>
				</c:forEach>
			</div>

			<div class="sucesso">
				<c:if test="${sucesso != null}">
					<p>${sucesso}</p>
				</c:if>
			</div>

			<form method="post"
				action="${linkTo[AgendamentoController].confirma}">
				<ul>
					<li><label for="contaOrigem">Conta de Origem:</label> <input
						id="conta_origem" type="text" name="transferencia.contaOrigem"
						maxlength="6">
					<li><label for="contaDestino">Conta Destino:</label> <input
						id="conta_destino" type="text" name="transferencia.contaDestino"
						maxlength="6"></li>
					<li><label for="valor">Valor:</label> <input type="text"
						id="valor" name="transferencia.valor" maxlength="18"></li>
					<li><label for="data">Data da Transferência:</label> <input
						id="data_agendamento" type="text"
						name="transferencia.dataAgendamento" maxlength="10"></li>
					<li><label for="">Tipo:</label> <select id="tipo"
						name="transferencia.tipo.id">
							<option value="0">Selecione</option>
							<c:forEach items="${tiposLista}" var="tipo">
								<option value="${tipo.id}">${tipo.nome}</option>
							</c:forEach>
					</select></li>
					<li><label for="taxa_calculada">Taxa:</label><span
						class="taxa" id="taxa_calculada">0</span></li>
				</ul>
				<input type="submit" onclick="formataContas()" value="Confirmar">
			</form>

		</section>

		<section class="tabela">
			<h2>Transferências agendadas</h2>
			<table cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td>Conta Origem</td>
						<td>Conta Destino</td>
						<td>Valor</td>
						<td>Data Agendada</td>
						<td>Tipo</td>
						<td>Taxa</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${transferencias}" var="transferencia"
						varStatus="status">
						<tr class="${(status.index % 2) == 0 ? 'linhapar':'linhaimpar'}">
							<td class="conta">${transferencia.contaOrigem}</td>
							<td class="conta">${transferencia.contaDestino}</td>
							<td class="valor">${transferencia.valor}</td>
							<td class="data">${transferencia.dataAgendamentoFormatada}</td>
							<td>${transferencia.tipo}</td>
							<td class="valor">${transferencia.taxa}</td>
						</tr>
					</c:forEach>
					<c:if test="${transferencias.size() == 0}">
						<tr class="linhapar lista-vazia">
							<td colspan="6">Nenhuma transferência agendada</td>
						</tr>
					</c:if>
				</tbody>
			</table>

		</section>

	</div>

	<script type="text/javascript">
		//<![CDATA[
		$(document).ready(function() {
			$("#conta_origem").mask("00000-0");
			$("#conta_destino").mask("00000-0");
			$("#data_agendamento").mask("00/00/0000");
			$("#valor").mask("000.000.000.000,00", {
				reverse : true
			});

			$(".conta").mask("00000-0");
			$(".conta").mask("00000-0");	
			$(".valor").mask("000.000.000.000,00");		
			$(".valor").mask("000.000.000.000,00");		
		});

		$(document).ready(function() {
			$("#tipo").on('change', calculaTaxa);
			$('#valor').focusout(calculaTaxa);
			$('#data_agendamento').focusout(calculaTaxa);
		});

		calculaTaxa = function() {
			var tipo = $("#tipo").val();
			var dataAgendamento = $("#data_agendamento").val();
			var valorTransacao = $("#valor").val();
			if (validaCampos(tipo, dataAgendamento, valorTransacao)) {
				valorTransacao = valorTransacao.split(".").join("");
				valorTransacao = valorTransacao.replace(",", ".");
				$.ajax({
					url:'http://localhost:8080/agendador-financeiro/transferencia/calculo',
					data:{idTipo: tipo, dataTransferencia: dataAgendamento, valor: valorTransacao},
					type:"GET",
					dataType:'json',
					success:function(data){  
						$('#taxa_calculada').html(data);  
					}
				});
			}
		};

		validaCampos = function(tipo, dataAgendamento, valorTransacao) {
			if (tipo == "" || tipo == "0") {
				return false;
			}
			if (dataAgendamento == "") {
				return false;
			}
			if (valorTransacao == "") {
				return false;
			}
			return true;
		};

		formataContas = function (){
			$("#conta_origem").val($("#conta_origem").val().replace("-",""));
			$("#conta_destino").val($("#conta_destino").val().replace("-",""));
		}
		
		//]]>
	</script>

</body>
</html>