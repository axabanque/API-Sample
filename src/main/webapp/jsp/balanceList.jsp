<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/header.jsp" />

<h2>balance List</h2>
<p>
	<strong>Customer :</strong> ${customerId}
</p>
<p>
	<strong>Account : </strong>${accountId}
</p>
<br />



<script src="http://code.highcharts.com/stock/highstock.js"></script>
<script src="http://code.highcharts.com/stock/modules/exporting.js"></script>
<h2>Your balances in the time ..</h2>
<br />
<div id="container" style="height: 500px; min-width: 500px"></div>

<script type="text/javascript">
$(function() {

    $.getJSON('http://www.highcharts.com/samples/data/jsonp.php?filename=aapl-c.json&callback=?', function(data) {
        // Create the chart
        window.chart = new Highcharts.StockChart({
            chart : {
                renderTo : 'container'
            },

            rangeSelector : {
                selected : 1
            },

            title : {
                text : 'Your balances in times'
            },
            
            series : [{
                name : 'AAPL',
                data : data,
                tooltip: {
                    valueDecimals: 2
                }
            }]
        });
    });

});
</script>

<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<th>account</th>
			<th>date</th>
			<th>amount</th>
			<th>currency</th>
		</tr>
	</thead>
	<c:forEach items="${balances}" var="balance">
		<tr>
			<td>${balance.account}</td>
			<td>${balance.date}</td>
			<td>${balance.amount}</td>
			<td>${balance.currency}</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/jsp/footer.jsp" />