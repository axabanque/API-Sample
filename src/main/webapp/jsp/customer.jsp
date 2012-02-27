<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/jsp/header.jsp" />

	<form:form method="POST" action="/simple-pfm/customer/customerAccounts" commandName="customerChoosed" class="well">
	
	<label>Choose a customer Id : </label>
	<form:select name="customerIdChoose" path="customerId">
		<option value="1000000">1000000</option>
		<option value="1000001">1000001</option>
		<option value="1000002">1000002</option>
		<option value="1500000">1500000</option>
	</form:select>
	
	<form:input type="submit" name="submit" value="Submit!" path="" class="btn-success" />
 	</form:form>

<jsp:include page="/jsp/footer.jsp" />
