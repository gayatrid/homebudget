<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" ng-app="myapp">
<head>
<title>Release Details</title>
<script src="https://code.angularjs.org/1.3.0-beta.5/angular.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/core/css/releaseDetails.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/core/css/table.css">
</head>
<body ng-controller="ViewReleaseDetailsController">
	<c:if test="${!empty releaseDetail.deployments}">
	<h4>Deployments</h4>
		<table class="zui-table zui-table-rounded">
			<thead>
				<tr>
					<th>Composite Name</th>
					<th>Partition</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${releaseDetail.deployments}" var="depolyment">
					<tr>
						<td>${depolyment.compositeName}</td>
						<td>${depolyment.partition}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<c:if test="${!empty releaseDetail.jmsObjects}">
	<h4>JMS</h4>
		<table class="zui-table zui-table-rounded">
			<thead>
				<tr>
					<th>JMS Type</th>
					<th>JNDI Name</th>
					<th>Name</th>
					<th>Connection Factory</th>
					<th>Sub Deployment</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${releaseDetail.jmsObjects}" var="jmsObject">
					<tr>
						<td>${jmsObject.jmsType}</td>
						<td>${jmsObject.jndiName}</td>
						<td>${jmsObject.jmsName}</td>
						<td>${jmsObject.connectionFactory}</td>
						<td>${jmsObject.subDeployment}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
	<c:if test="${!empty releaseDetail.dataSourceObjects}">
	<h4>Data Source</h4>
		<table class="zui-table zui-table-rounded">
			<thead>
				<tr>
					<th>Data Source Name</th>
					<th>DataBase Host</th>
					<th>DataBase Port</th>
					<th>User Name</th>
					<th>DataBase Server Name</th>
					<th>User Name</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${releaseDetail.dataSourceObjects}" var="dsObject">
					<tr>
						<td>${dsObject.dataSourceName}</td>
						<td>${dsObject.dataSourceJNDI}</td>
						<td>${dsObject.dataBaseHost}</td>
						<td>${dsObject.dataBasePort}</td>
						<td>${dsObject.dataBaseServerName}</td>
						<td>${dsObject.userName}</td>
						<td>${dsObject.password}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<c:if test="${!empty releaseDetail.ftpAdapterObject}">
	<h4>FTP Adapter</h4>
		<table class="zui-table zui-table-rounded">
			<thead>
				<tr>
					<th>JNDI</th>
					<th>CFI</th>
					<th>CI</th>
					<th>CP</th>
					<th>Host</th>
					<th>port</th>
					<th>User</th>
					<th>Password</th>
					<th>SFTP</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${releaseDetail.ftpAdapterObject}"
					var="adapterObject">
					<tr>
						<td>${adapterObject.ftpJNDI}</td>
						<td>${adapterObject.ftpCFI}</td>
						<td>${adapterObject.ftpCI}</td>
						<td>${adapterObject.ftpCP}</td>
						<td>${adapterObject.host}</td>
						<td>${adapterObject.port}</td>
						<td>${adapterObject.user}</td>
						<td>${adapterObject.password}</td>
						<td>${adapterObject.sftp}</td>
					</tr>
				</c:forEach>
				</tbody></table>
	</c:if>


	<c:if test="${!empty releaseDetail.mdsObjects}">
	<h4>MDS</h4>
		<table class="zui-table zui-table-rounded">
			<thead>
				<tr>
					<th>Server Location</th>
					<th>Target</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${releaseDetail.mdsObjects}" var="mdsObject">
					<tr>
						<td>${mdsObject.serverLocation}</td>
						<td>${mdsObject.target}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<c:if test="${!empty releaseDetail.cronJobs}">
	<h4>CRON JOB</h4>
		<table class="zui-table zui-table-rounded">
			<thead>
				<tr>
					<th>Cron Job</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${releaseDetail.cronJobs}" var="cronJob">

					<tr>
						<td>${cronObject.cronJob}</td>
					</tr>
				</c:forEach>
				</tbody></table>
	</c:if>

	
</body>
</html>
