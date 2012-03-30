<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/header.jsp" />

	<h2>Account List </h2>
	
	<p>
		<strong>Customer :</strong> ${customerId}
	</p>

	<p>
		<i>Click on account number to see transactions</i>
		<br/>
		<i>Click on "Balances in time" to see graphic of your balances in time</i>
	</p>

	<table class="table table-striped table-bordered table-condensed">
		<thead>
		<tr>
			<th>Label</th>
			<th>Account Number</th>
			<th>Amount</th>
			<th>Balances</th>
		</tr>
		</thead>
		<c:forEach items="${accounts}" var="account">
			<tr>
				<td>${account.label}</td>
				<td><a href="${pageContext.request.contextPath}/customer/${customerId}/accounts/show/${account.account}/page/1">${account.account}</a></td>
				<td>${account.amount}</td>
				<td><a href="${pageContext.request.contextPath}/customer/${customerId}/balances/show/${account.account}">Balances in time</a></td>
			</tr>
		</c:forEach>
	</table>
	
<jsp:include page="/jsp/footer.jsp" />