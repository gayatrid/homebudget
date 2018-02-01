<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/core/css/table.css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/core/css/layout.css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/core/css/common.css">

</head>
<body bgcolor="#F4F7FC">
	<form:form method="post" action="addRecord" commandName="spendingForm"
		enctype="multipart/form-data">
		<div id="upright">
			<table>
				<tr><td colspan="6" align="center"><form:input path="month" type="month"/><input type="submit" value="View" name="search" /></td></tr>
				<tr></tr>
				<tr>
					<td><form:select path="storeId">
							<form:options items="${stores}" itemValue="id"
								itemLabel="storeName" />
						</form:select></td>
					<td><form:input	 type="date"  path="transactionDate" /></td>
					<td><form:input type="number" path="price" placeholder="Price" /></td>
					<td><form:input path="description" placeholder="Description" /></td>

					<td><form:select path="bankName">
							<form:option value="American Express">American Express</form:option>
							<form:option value="DCU">DCU</form:option>
							<form:option value="TD Bank">TD Bank</form:option>
							<form:option value="Lali BOA">Lali BOA</form:option>
							<form:option value="VISA">VISA</form:option>
							<form:option value="Cash">Cash</form:option>
						</form:select>
					<td><input type="submit" value="Add" name="addSpending" /></td>
				</tr>
			</table>
			<c:if test="${!empty spendingList}">
				<div class="scrolldiv">
					<table class="zui-table zui-table-rounded">
						<thead>
							<tr>
								<th>Store</th>
								<th>Date</th>
								<th>Price</th>
								<th>Description</th>
								<th>Bank Name</th>
								<th></th>
							</tr>
						</thead>
						<c:forEach items="${spendingList}" var="spend">
							<tr>
								<td>${spend.store.storeName}</td>
								<td><fmt:formatDate value="${spend.transactionDate}" type="date" pattern="MM-dd-yyyy"/></td>
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