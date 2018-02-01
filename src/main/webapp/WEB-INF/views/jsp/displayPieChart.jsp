<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/core/css/table.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/core/css/layout.css">
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/core/css/common.css">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script
	src="<%=request.getContextPath()%>/resources/core/js/googleGraph.js"></script>
<script type="text/javascript">
//Load the Visualization API and the piechart package.
google.load('visualization', '1.0', {
	'packages' : [ 'corechart' ]
});

// Set a callback to run when the Google Visualization API is loaded.
google.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {

	// Create the data table.	
	var data = google.visualization.arrayToDataTable([    	['Spending', 'Area(square km)'],
	                                                  	<c:forEach items="${incomeAndExpenses}" var="spending">
	                          								[ '${spending.description}', ${spending.price} ],
	                          							</c:forEach>
	                                                ]);
	
	
	// Create the data table.	
	var data2 = google.visualization.arrayToDataTable([    	['Spending', 'Area(square km)'],
	                                                  	<c:forEach items="${spendingInStores}" var="spending">
	                          								[ '${spending.store.storeName}', ${spending.price} ],
	                          							</c:forEach>
	                                                ]);
	
	
	// Set chart options
	var options = {
		'title' : 'Income And Expenses',
		is3D : true,
		pieSliceText: 'label',
		tooltip :  {showColorCode: true},
		'width' : 600,
		'height' : 400
	};
	
	var options2 = {
			'title' : 'Area of expenses',
			is3D : true,
			pieSliceText: 'label',
			tooltip :  {showColorCode: true},
			'width' :600,
			'height' : 400
		};

	// Instantiate and draw our chart, passing in some options.
	var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
	chart.draw(data, options);
	var chart = new google.visualization.PieChart(document.getElementById('profit_loss'));
	chart.draw(data2, options2);
}


</script>
</head>
<body bgcolor="#F4F7FC">
	<form:form method="post" action="viewIncomeAndExpenses" commandName="spendingForm">
		<table>
			<tr>
				<td colspan="6" align="center"><form:input path="month"
						type="month" /><input type="submit" value="View "
					name="view" /></td>
			</tr>
		</table>
		

		<c:if test="${!empty incomeAndExpenses}">
				<div id="chart_div"></div>
				<div id="profit_loss"></div>

		</c:if>

	</form:form>
</body>
</html>