<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/header.jsp" />

	<h2>Account List </h2>
	
	<p>
		<strong>Customer :</strong> ${customerId}
	</p>

	<table class="table table-striped table-bordered table-condensed">
		<thead>
		<tr>
			<th>Label</th>
			<th>Account Number</th>
		</tr>
		</thead>
		<c:forEach items="${accounts}" var="account">
			<tr>
				<td>${account.label}</td>
				<td><a href="${pageContext.request.contextPath}/accounts/show/${account.account}/page/1">${account.account}</a></td>
			</tr>
		</c:forEach>
	</table>
	
<jsp:include page="/jsp/footer.jsp" />