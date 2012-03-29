<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/jsp/header.jsp" />

<h1>Choose a customer Id :</h1>
<c:forEach items="${customers}" var="customerId">
	<br />
	<a href="${pageContext.request.contextPath}/customer/${customerId}">${customerId}</a>
</c:forEach>

<jsp:include page="/jsp/footer.jsp" />
