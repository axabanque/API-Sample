<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/header.jsp" />

<h2>Balance List</h2>

<br />
<a href="${pageContext.request.contextPath}/customer/${customerId}">Go Back to list of accounts</a>
<br />

<p>
	<strong>Customer :</strong> ${customerId}
</p>
<p>
	<strong>Account : </strong>${accountId}
</p>
<br />

<br />
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Date');
        data.addColumn('number', 'Amount');
        <c:forEach items="${balances}" var="balance" varStatus="loop">
                data.addRows([['${balance.date}',${balance.amount}]]);
                </c:forEach>
        var options = {
          title: 'Your balances in time ...',
          hAxis: {title: 'Date',  titleTextStyle: {color: 'black'}}
        };
        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
<div id="chart_div" style="width: 900px; height: 500px;"></div>
<br /><br />


<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<th>Date</th>
			<th>Amount</th>
			<th>Currency</th>
		</tr>
	</thead>
	<c:forEach items="${balances}" var="balance">
		<tr>
			<td>${balance.date}</td>
			<td>${balance.amount}</td>
			<td>${balance.currency}</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/jsp/footer.jsp" />