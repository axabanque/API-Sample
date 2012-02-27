<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/header.jsp" />

<h2>Transaction List</h2>
<p>
	<strong>Customer :</strong> ${customerId}
</p>
<p>
	<strong>Account : </strong>${accountId}
</p>
<br />

<div class="pagination">
	<ul>
		<li><a href="#">Prev</a></li>
		<li class="active"><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">Next</a></li>
	</ul>
</div>

<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<th>Id</th>
			<th>Account</th>
			<th>Transaction Type</th>
			<th>Entry Date</th>
			<th>Value Date</th>
			<th>Label</th>
			<th>Amount</th>
			<th>Currency</th>
			<th>Transaction Date</th>
			<th>Card Number</th>
			<th>Card Type</th>
		</tr>
	</thead>
	<c:forEach items="${transactions}" var="transaction">
		<tr>
			<td>${transaction.id}</td>
			<td>${transaction.account}</td>
			<td>${transaction.transactionType}</td>
			<td>${transaction.entryDate}</td>
			<td>${transaction.valueDate}</td>
			<td>${transaction.label}</td>
			<td>${transaction.amount}</td>
			<td>${transaction.currency}</td>
			<td>${transaction.transactionDate}</td>
			<td>${transaction.cardNumber}</td>
			<td>${transaction.cardType}</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/jsp/footer.jsp" />