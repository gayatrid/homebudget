<html lang="en" ng-app="myapp">
<head>
<title>Release Details</title>
<script src="https://code.angularjs.org/1.3.0-beta.5/angular.js"></script>
<script src="releaseDetails.js"></script>
<link rel="stylesheet" href="releaseDetails.css">
</head>
<body ng-controller="ReleaseDetailsController">
	<form ng-submit="addNew(releaseDetails)" novalidate>
		<div class="header">
			<table align="left">
				<tr>
					<td>Ticket Number<br> <input class="form-control"
						type="text" name="ticketNumber"></td>
					<td>Release Date<br> <input class="form-control"
						id="date" type="date" value="2017-06-01" /></td>
				</tr>
				<tr>
					<td>ITSN<input type="radio" name="ticketType" />PR<input
						type="radio" name="ticketType" />
					</td>
					<td></td>
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
					<td><button name="Deployment" class="button"
							ng-click="type='JMS'">JMS</button></td>
				</tr>
				<tr>
					<td><button name="Deployment" class="button"
							ng-click="type='DB'">DataBase</button></td>
				</tr>
				<tr>
					<td><button name="Deployment" class="button"
							ng-click="type='MDS'">MDS</button></td>
				</tr>
				<tr>
					<td><button name="Deployment" class="button"
							ng-click="type='Adapter'">Adapter</button></td>
				</tr>
			</table>
		</div>

		<div class="rightDiv">
			<div ng-show="type=='deployment'">
				<table>
					<tr>
						<td>Composite_Name<br> <input class="form-control"
							type="text" placeholder="Compsite Name"
							ng-model="releaseDetails.compositeName" required></td>
						<td>Partition<br> <select class="form-control"
							ng-model="releaseDetails.partition" required>
								<option value="Defult" selected>
								<option value="Defult">Defult</option>
								<option value="gg">gg</option>
								<option value="hh">hh</option>
						</select>
						</td>
						<td><input type="submit" value="Add New" class="smallButton">
						</td>
					</tr>
				</table>
				<div ng-hide="!releaseDetails.length">
					<table>
						<thead>
							<tr>
								<th>Composite Name</th>
								<th>Partition</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="releaseDetail in releaseDetails">
								<td>{{releaseDetail.compositeName}}</td>
								<td>{{releaseDetail.partition}}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div ng-show="type=='JMS'">
				<table>
					<tr>
						<td>Queue<input type="radio" name="jmsT" />Topic<input
							type="radio" name="jmsT" />
						</td>
						<td>JNDI Name<br> <input class="form-control"
							type="text" placeholder="JNDI Name"
							ng-model="releaseDetails.JNDIname" required></td>
						<td>Topic Name</td>
						<td><input class="form-control" type="text"
							placeholder="Topic Name" ng-model="releaseDetails.topicName"
							required></td>
						</td>
						<td><input type="submit" value="Add" class="submitBtn">
						</td>
					</tr>
				</table>
				<div ng-hide="!releaseDetails.length">
					<table>
						<thead>
							<tr>
								<th>JMS Type</th>
								<th>JNDI Name</th>
								<th>Topic Name</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="releaseDetail in releaseDetails">
								<td>{{releaseDetail.JNDIname}}</td>
								<td>{{releaseDetail.JNDIname}}</td>
								<td>{{releaseDetail.topicName}}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div ng-show="type=='DB'"></div>
			<div ng-show="type=='Adapter'"></div>
			<div ng-show="type=='MDS'"></div>
		</div>
		<div class="bottomDiv">
			<input type="submit" value="View & Export" class="submitBtn">
			<input type="submit" value="Submit" class="submitBtn">
		</div>
	</form>
</body>
</html>
