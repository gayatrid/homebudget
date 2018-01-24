<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" ng-app="myapp">
<head>
<title>Release Details</title>
<script src="https://code.angularjs.org/1.3.0-beta.5/angular.js"></script>
<script src="<%=request.getContextPath() %>/resources/core/js/releaseDetails.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/core/css/releaseDetails.css"/>
<link rel="stylesheet"  href="<%=request.getContextPath() %>/resources/core/css/table.css">
</head>
<body ng-controller="ReleaseDetailsController">
	
	
	<form >
		<div class="header">
			<table align="left">
				<tr>
				 <td>ITSM</td><td><input type="radio" ng-model="releaseDetails.ticketType"/></td>
				 <td>PR</td><td><input type="radio" ng-model="releaseDetails.ticketType" /></td>
					<td><input  type="text" ng-model="releaseDetails.ticketNumber"	placeholder="Ticket Number"></td>
					<td><input  type="date"  ng-model="releaseDetails.releaseDate" /></td>
					<td><input  	ng-model="releaseDetails.releaseDescription" type="text" placeholder="Release Description" /></td>
				
				</tr>
				
			</table>
		</div>


		<div class="leftDiv">
			<table width="100%" height="100%" class="btn-group">
				<tr>
					<td>
						<button name="Deployment" class="button"
							ng-click="type='deployment'">Depolyment</button>
					</td>
				</tr>
				<tr>
					<td><button name="JMS" class="button"
							ng-click="type='JMS'">JMS</button></td>
				</tr>
				<tr>
					<td><button name="Deployment" class="button"
							ng-click="type='DS'">Data Source</button></td>
				</tr>
				<tr>
					<td><button name="Adapter" class="button"
							ng-click="type='Adapter'">Adapter</button></td>
				</tr>
				<tr>
					<td><button name="MDS" class="button"
							ng-click="type='MDS'">MDS</button></td>
				</tr>
				<tr>
					<td><button name="CronJob" class="button"
							ng-click="type='CronJob'">Cron Job</button></td>
				</tr>
			</table>
		</div>

		<div class="rightDiv">
			<div ng-show="type=='deployment'">
				<table>
					<tr>
						<td><input class="form-control" type="text"
							placeholder="Compsite Name"
							ng-model="releaseDetails.compositeName" required></td>
						<td>
							<select class="form-control" ng-model="releaseDetails.partition" required>
							<c:forEach items="${paritionList}" var="partition" varStatus="myIndex">
										<option value="${partition.id}" selected>${partition.description}</option>
									</c:forEach>
							</select>
						</td>
						<td><input type="submit" value="Add New" class="smallButton"ng-click="addNew(releaseDetails)"></td>
					</tr>
				</table>
				<div ng-hide="!deploymentDetails.length" class="scrolldiv">
					<table class="zui-table zui-table-rounded">
						<thead>
							<tr>
								<th>Composite Name</th>
								<th>Partition</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<tr
								ng-repeat="(deploymentObjectIndex,deploymentObject) in deploymentDetails">
								<td>{{deploymentObject.compositeName}}</td>
								<td>{{deploymentObject.partition}}</td>
								<td><input type="button" class="delete" value="X"
									data-ng-click="removeDeployment(deploymentObjectIndex)" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div ng-show="type=='JMS'">
				<table>
					<tr>
						<td>Queue</td>
						<td><input type="radio" ng-model="releaseDetails.jmsType"
							ng-value='"Q"' ng-checked="true"
							data-ng-click="queueChecked()" /></td>
						<td>Topic</td>
						<td><input type="radio" ng-model="releaseDetails.jmsType"
							ng-value='"T"' ng-click="topicChecked()" /></td>

						<td><input class="form-control" type="text"
							placeholder="JNDI Name" ng-model="releaseDetails.jndiName"
							required></td>
						<td><input class="form-control" type="text"
							placeholder="{{jmsPlaceHolderNameName}}" ng-model="releaseDetails.jmsName"
							required></td>
						<td><input class="form-control" type="text"
							placeholder="{{connectionFactory}}"
							ng-model="releaseDetails.connectionFactory" required></td>
						<td><input class="form-control" type="text"
							placeholder="Sub Deployment"
							ng-model="releaseDetails.subDeployment" required></td>
						<td><input type="submit" value="Add New" class="smallButton"
							ng-click="addJMS(releaseDetails)"></td>

					</tr>
				</table>
				<div ng-hide="!jmsDetails.length" class="scrolldiv">
					<table class="zui-table zui-table-rounded">
						<thead>
							<tr>
								<th>JMS Type</th>
								<th>JNDI Name</th>
								<th>Name</th>
								<th>Connection Factory</th>
								<th>Sub Deployment</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(jmsObjectIndex, jmsObject) in jmsDetails">
								<td>{{jmsObject.jmsType}}</td>
								<td>{{jmsObject.jndiName}}</td>
								<td>{{jmsObject.jmsName}}</td>
								<td>{{jmsObject.connectionFactory}}</td>
								<td>{{jmsObject.subDeployment}}</td>
								<td><input type="button" class="delete" value="X"
									data-ng-click="removeJMS(jmsObjectIndex)" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div ng-show="type=='DS'">
				<table>
					<tr>

						<td><input class="form-control" type="text"
							placeholder="Data Source Name" ng-model="releaseDetails.dataSourceName"
							required></td>
						<td><input class="form-control" type="text"
							placeholder="Data Source JNDI" ng-model="releaseDetails.dataSourceJNDI"
							required></td>
						<td><input class="form-control" type="text"
							placeholder="Data Base Host" ng-model="releaseDetails.dataBaseHost"
							required></td>
						<td><input class="form-control" type="text"
							placeholder="Data Base Port" ng-model="releaseDetails.dataBasePort"
							required></td>
					<tr></tr>
					<td><input class="form-control" type="text"
						placeholder="Data Base Server Name"
						ng-model="releaseDetails.dataBaseServerName" required></td>
					<td><input class="form-control" type="text"
						placeholder="User Name" ng-model="releaseDetails.userName"
						required></td>
					<td><input class="form-control" type="text"
						placeholder="Password" ng-model="releaseDetails.password" required></td>
					<td><input type="submit" value="Add New" class="smallButton"
						ng-click="addDataSource(releaseDetails)"></td>
					</tr>
				</table>
				<div ng-hide="!dataSourceDetails.length" class="scrolldiv">
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
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(dsObjectIndex ,dsObject) in dataSourceDetails">
								<td>{{dsObject.dataSourceName}}</td>
								<td>{{dsObject.dataSourceJNDI}}</td>
								<td>{{dsObject.dataBaseHost}}</td>
								<td>{{dsObject.dataBasePort}}</td>
								<td>{{dsObject.dataBaseServerName}}</td>
								<td>{{dsObject.userName}}</td>
								<td>{{dsObject.password}}</td>
								<td><input type="button" class="delete" value="X"
									data-ng-click="removeDataSource(dsObjectIndex)" /></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
			<div ng-show="type=='Adapter'">
				<table>
					<tr>
						<td>FTP Adapter<input type="radio" name="jmsT" />DB Adapter<input
							type="radio" name="jmsT" />
						</td>
						<td><input class="form-control" type="text"
							placeholder="JNDI" ng-model="releaseDetails.ftpJNDI" required></td>
						<td><input class="form-control" type="text" placeholder="CFI"
							ng-model="releaseDetails.ftpCFI" required></td>
						<td><input class="form-control" type="text" placeholder="CI"
							ng-model="releaseDetails.ftpCI" required></td>
						<td><input class="form-control" type="text" placeholder="CP"
							ng-model="releaseDetails.ftpCP" required></td>
						<td><input class="form-control" type="text"
							placeholder="host" ng-model="releaseDetails.host" required></td>
					</tr>
					<tr>
						<td><input class="form-control" type="text"
							placeholder="port" ng-model="releaseDetails.port" required></td>
						<td><input class="form-control" type="text"
							placeholder="user" ng-model="releaseDetails.user" required></td>
						<td><input class="form-control" type="text"
							placeholder="password" ng-model="releaseDetails.password"
							required></td>
						<td><input class="form-control" type="text"
							placeholder="sftp" ng-model="releaseDetails.sftp" required></td>


						<td><input type="submit" value="Add New" class="smallButton"
							ng-click="addAdapter(releaseDetails)"></td>
					</tr>
				</table>
				<div ng-hide="!adapterDetails.length" class="scrolldiv">
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
								<th>Delete</th>

							</tr>
						</thead>
						<tbody>
							<tr
								ng-repeat="(adapterObjectIndex,adapterObject) in adapterDetails">
								<td>{{adapterObject.ftpJNDI}}</td>
								<td>{{adapterObject.ftpCFI}}</td>
								<td>{{adapterObject.ftpCI}}</td>
								<td>{{adapterObject.ftpCP}}</td>
								<td>{{adapterObject.host}}</td>
								<td>{{adapterObject.port}}</td>
								<td>{{adapterObject.user}}</td>
								<td>{{adapterObject.password}}</td>
								<td>{{adapterObject.sftp}}</td>
								<td><input type="button" class="delete" value="X"
									data-ng-click="removeAdapter(adapterObjectIndex)" /></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
			<div ng-show="type=='MDS'">

				<table>
					<tr>
						<td><input class="form-control" type="text"
							placeholder="Source"
							ng-model="releaseDetails.serverLocation" required></td>
						<td><input class="form-control" type="text"
							placeholder="Target" ng-model="releaseDetails.target" required></td>
						<td><input type="submit" value="Add New" class="smallButton"
							ng-click="addMDS(releaseDetails)"></td>
					</tr>
				</table>
				<div ng-hide="!mdsreleaseDetails.length" class="scrolldiv">
					<table class="zui-table zui-table-rounded">
						<thead>
							<tr>
								<th>Source</th>
								<th>Target</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(mdsObjectIndex ,mdsObject) in mdsreleaseDetails">
								<td>{{mdsObject.serverLocation}}</td>
								<td>{{mdsObject.target}}</td>
								<td><input type="button" class="delete" value="X"
									data-ng-click="removeMDS(deploymentObjectIndex)" /></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
			<div ng-show="type=='CronJob'">

				<table>
					<tr>
						<td><textarea class="form-control"	placeholder="Cron Job"	ng-model="releaseDetails.cronJob" required rows="4" cols="50"></textarea></td>
							<td><input type="submit" value="Add New" class="smallButton"
							ng-click="addCronJob(releaseDetails)"></td>
					</tr>
				</table>
				<div ng-hide="!cronJobDetails.length" class="scrolldiv">
					<table class="zui-table zui-table-rounded">
						<thead>
							<tr>
								<th>Cron Job</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(cronObjectIndex, cronObject) in cronJobDetails">
								<td>{{cronObject.cronJob}}</td>
								<td><input type="button" class="delete" value="X"
									data-ng-click="removeCronJob(cronObjectIndex)" /></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
		<div class="bottomDiv">
			<input type="submit" value="Submit" class="submitBtn" ng-click="submitRD()">
		</div>
</form>		
</body>
</html>
