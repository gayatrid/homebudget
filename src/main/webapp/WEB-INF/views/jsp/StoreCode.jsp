<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/core/css/table.css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/core/css/layout.css">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="<%=request.getContextPath() %>/resources/core/js/googleGraph.js"></script>
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
	                                                  	<c:forEach items="${spendingList}" var="entry">
	                          								[ '${entry.description}', ${entry.price} ],
	                          							</c:forEach>
	                                                ]);
	
	
	// Create the data table.	
	var data2 = google.visualization.arrayToDataTable([    	['Spending', 'Area(square km)'],
	                                                  	<c:forEach items="${spendingList}" var="entry">
	                          								[ '${entry.description}', ${entry.price} ],
	                          							</c:forEach>
	                                                ]);
	
	
	// Set chart options
	var options = {
		'title' : 'Proft and Loss',
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
<script type="text/javascript">
	$(function() {
		$('#idDateField').datepicker();
	});
</script>
</head>
<body bgcolor="#F4F7FC" >
<form:form method="post" action="addRecord"	commandName="spendingForm" enctype="multipart/form-data">
<div id="upleft" >
					
					 <table>
        <tr>
            <td><form:label path="file">Select a file to upload</form:label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" name="uploadFile"  value="Upload" /></td>
        </tr>
    </table>
    <h3>Add Income</h3>
					<table>
						<tr>
							<td><form:input path="credit" placeholder="Income"/></td>
							<td><fmt:formatDate value="${spending.incomeDate}"	pattern="MM-dd-yyyy" var="payDatevar" />
								<form:input id="idDateField" type="date" value="${payDatevar}" path="incomeDate" /></td>
							<td><form:input path="incomeDescription" placeholder="Description Income"/></td>
							<td><input type="submit" name ="addCredit"  value="Add" /></td>
						</tr>
					</table>
					<c:if test="${!empty creditList}">
						<div class="scrolldiv">
							<table class="zui-table zui-table-rounded">
								<thead><tr><th>Income</th><th>Date</th><th>Description</th><th></th></tr></thead>
								<c:forEach items="${creditList}" var="credit">
									<tr>
										<td>${credit.credit}</td>
										<td>${credit.incomeDate}</td>
										<td>${credit.incomeDescription}</td>
										<td>Delete</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</c:if>
</div>
<div id="upright" >
					<h3>Add Expenses</h3>
					<table>
						<tr>
							<td><form:select path="storeId">
									<form:options items="${stores}" itemValue="id"	itemLabel="storeName" />
								</form:select></td>
							<td><fmt:formatDate value="${spending.payDate}"	pattern="MM-dd-yyyy" var="payDatevar" />
								<form:input id="idDateField" type="date" value="${payDatevar}" path="payDate" /></td>
							<td><form:input path="price" placeholder="Price"/></td>
							<td><form:input path="description" placeholder="Description"/></td>
							
							<td>
								<form:select path="bankName">
								<form:option value="American Express">American Express</form:option>
								<form:option value="DCU">DCU</form:option>
								<form:option value="TD Bank">TD Bank</form:option>
								<form:option value="Lali BOA">Lali BOA</form:option>
								<form:option value="VISA">VISA</form:option>
								<form:option value="Cash">Cash</form:option>
								</form:select>
							<td><input type="submit" value="Add" name="addSpending"/></td>
						</tr>
					</table>
					<c:if test="${!empty spendingList}">
						<div class="scrolldiv">
							<table class="zui-table zui-table-rounded">
								<thead><tr><th>Store</th><th>Date</th><th>Description</th>	<th>Price</th><th>Bank Name</th><th></th></tr></thead>
								<c:forEach items="${spendingList}" var="spend">
									<tr>
										<td>${spend.store.storeName}</td>
										<td>${spend.payDate}</td>
										<td>${spend.price}</td>
										<td>${spend.description}</td>
										
										<td>${spend.bankName}</td>
										<td><a href="./delete/${spend.id}">Delete</a> <%-- <a href="./edit/${spend.id}">Edit</a> --%>
										</td>

									</tr>
								</c:forEach>
							</table>
						</div>
					</c:if>
</div>
<div id="below">
			
						<div id="chart_div"></div>
						<div id="profit_loss"></div>
</div>
</form:form>
</body>
</html>