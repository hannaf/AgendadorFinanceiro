<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<title>Agendar Transferencia</title>
	<script type="text/javascript" src="<c:url value="resources/js/jquery-2.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.mask.min.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/style.css"/>">
	
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

			<form method="post" action="${linkTo[AgendamentoController].confirma}">
				<ul>
					<li><label for="contaOrigem">Conta de Origem:</label> <input id="conta_origem"
						type="text" name="transferencia.contaOrigem" maxlength="6">
					
					<li><label for="contaDestino">Conta Destino:</label> <input id="conta_destino"
						type="text" name="transferencia.contaDestino" maxlength="6">
					</li>
					<li><label for="valor">Valor:</label> <input type="text" id="valor"
						name="transferencia.valor" maxlength="18"></li>
					<li><label for="data">Data da Transferência:</label> <input id="data_agendamento"
						type="text" name="transferencia.dataAgendamento" maxlength="10">
					</li>
					<li><label for="">Tipo:</label> <select id="tipo" name="transferencia.tipo.id">
							<option value="0">Selecione</option>
							<c:forEach items="${tiposLista}" var="tipo">
								<option value="${tipo.id}">${tipo.nome}</option>
							</c:forEach>
					</select></li>
					<li><label for="taxa">Taxa:</label><p></p>
					</li>
				</ul>
				<input type="submit" value="Confirmar">
			</form>

		</section>

	<section class="tabela">
			<h2>Transferências agendadas</h2>
			<table cellpadding="3" cellspacing="0">
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
					<c:forEach items="${transferencias}" var="transferencia" varStatus="status">
						<tr class="${(status.index % 2) == 0 ? 'linhapar':'linhaimpar'}">
							<td>${transferencia.contaDestino}</td>
							<td>${transferencia.valor}</td>
							<td>${transferencia.dataAgendamento}</td>
							<td>${transferencia.tipo}</td>
							<td>${transferencia.taxa}</td>
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
	
		$(document).ready(function(){
			$("#conta_origem").mask("00000-0");
			$("#conta_destino").mask("00000-0");
			$("#data_agendamento").mask("00/00/0000");
			$("#valor").mask("000.000.000.000,00", {reverse: true});
		});
		
// 		$(document).ready(function() {
// 			$("#tipo").on('change',function(){
// 				var self = $(this);  
// 			    var selecionado = self.val();
// 			    var dataAgendamento = self.val();
// 			    var valor = self.val();
// 			    $.ajax({
// 					url:'/transferencia/calculo',
// 					data:{id:selecionado},
// 					dataType:'json',
// 			         success:function(data){  
// 			             // Precisa transformar de json para objeto html  
// 			             var options = [];  
// 			             options.push(' <option>Selecione</option> '); // colocando a primeira option...  
// 			             for (var i = 0; i < data.length; i++) {  
// 			                options.push('<option value="'+data[i].id+'">'+data[i].nome+'</option>');  
// 			             }  
// 			             $('#cidadesSelect').html(options.join(''));  
// 			          },  
// 			          error:function(){  
// 			             alert('erro');  
// 			          }  
// 				});
// 			});
// 		});
	</script>

</body>
</html>