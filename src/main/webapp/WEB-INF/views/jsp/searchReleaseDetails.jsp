<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en" ng-app="myapp">
<head>
<title>Search Release Details</title>
<script src="https://code.angularjs.org/1.3.0-beta.5/angular.js"></script>
<script src="<%=request.getContextPath() %>/resources/core/js/searchReleaseDetails.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/core/css/releaseDetails.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/core/css/table.css">
</head>

<body ng-controller="SearchReleaseDetailsController">
	<div>
		<form:form method="post" action="searchReleaseDetails"
			commandName="releaseDetailsForm">
			<table>
				<tr>
					<td>Ticket Number<form:input type="text" path="ticketNumber" /></td>
					<td>From Date<form:input type="date" path="fromDate" /></td>
					<td>To Date<form:input type="date" path="ToDate"/></td>
					<td><input type="submit" value="Search" class="smallButton" /></td>
				</tr>
			</table>
		</form:form>
		<c:if test="${!empty releaseDetails}">
			<div>
				<table class="zui-table zui-table-rounded" >
					<thead>
						<tr>
							
							<th>Composite Name</th>
							<th>Partition</th>
							<th>Ticket Number</th>
							<th>Release Date</th>
							<th>Release Description</th>
						</tr>
					</thead>
					<c:forEach items="${releaseDetails}" var="rd">
					<c:choose>
						<c:when test="${!empty (rd.deployments)}">
								<c:forEach items="${rd.deployments}" var="depolyment" varStatus="myIndex">
									<tr>
									<td>${depolyment.compositeName}</td>
									<td>${depolyment.partition}</td>
									<td><a data-ng-click="OpenPopupWindow('${rd.id}')">${rd.ticketNumber}-${rd.id}</a></td>
									<td>${rd.releaseDate}</td>
									<td>${rd.releaseDescription}</td>
									</tr>
								</c:forEach>
						</c:when>
						<c:otherwise>
						<tr>
						    <td colspan="2">No Deployment </td>
						    <td><a data-ng-click="OpenPopupWindow('${rd.id}')">${rd.ticketNumber}-${rd.id}</a></td>
									<td>${rd.releaseDate}</td>
									<td>${rd.releaseDescription}</td>
									</tr>
						</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</table>
			</div>
		</c:if>

	</div>
</body>


</body>
</html>
