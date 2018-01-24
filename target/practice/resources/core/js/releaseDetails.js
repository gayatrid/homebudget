var app = angular.module("myapp", []);
app.controller("ReleaseDetailsController", [ '$scope','$http','$window', function($scope,$http,$window) {
	$scope.releaseDetails = [];
	$scope.deploymentDetails = [];
	$scope.jmsDetails = [];
	$scope.dataSourceDetails = [];
	$scope.adapterDetails = [];
	$scope.mdsreleaseDetails = [];
	$scope.cronJobDetails = [];

	$scope.addNew = function(releaseDetails) {
		$scope.deploymentDetails.push({
			'compositeName' : releaseDetails.compositeName,
			'partition' : releaseDetails.partition,
		});
		$scope.releaseDetails.compositeName = '';
		// $scope.$setPristine(true);
		$scope.PD = {};
	};

	 $scope.removeDeployment = function (deploymentIndex) {
		    $scope.deploymentDetails.splice(deploymentIndex, 1);
		  }
	 
	$scope.addJMS = function(releaseDetails) {
		$scope.jmsDetails.push({
			'jmsType' : releaseDetails.jmsType,
			'jndiName' : releaseDetails.jndiName,
			'jmsName' : releaseDetails.jmsName,
			'connectionFactory' : releaseDetails.connectionFactory,
			'subDeployment' : releaseDetails.subDeployment,
		});
		
		 $scope.removeJMS = function (topicIndex) {
			    $scope.jmsDetails.splice(topicIndex, 1);
			  }
		 
		// $scope.$setPristine(true);
		$scope.PD = {};
	};
	$scope.addDataSource= function(releaseDetails) {
		$scope.dataSourceDetails.push({
			'dataSourceName' : releaseDetails.dataSourceName,
			'dataSourceJNDI' : releaseDetails.dataSourceJNDI,
			'dataBaseHost' : releaseDetails.dataBaseHost,
			'dataBasePort' : releaseDetails.dataBasePort,
			'dataBaseServerName' : releaseDetails.dataBaseServerName,
			'userName' : releaseDetails.userName,
			'password' : releaseDetails.password,
		});
		
		 $scope.removeDataSource = function (dataSourceIndex) {
			    $scope.dataSourceDetails.splice(dataSourceIndex, 1);
			  }
		 
		// $scope.$setPristine(true);
		$scope.PD = {};
	};
	$scope.addMDS = function(releaseDetails) {
		$scope.mdsreleaseDetails.push({
			'serverLocation' : releaseDetails.serverLocation,
			'target' : releaseDetails.target,
		});
		
		 $scope.removeMDS = function (mdsIndex) {
			    $scope.mdsreleaseDetails.splice(mdsIndex, 1);
			  }
		 
		// $scope.$setPristine(true);
		$scope.PD = {};
	};
	$scope.addAdapter = function(releaseDetails) {
		$scope.adapterDetails.push({
			'ftpJNDI' : releaseDetails.ftpJNDI,
			'ftpCFI' : releaseDetails.ftpCFI,
			'ftpCI' : releaseDetails.ftpCI,
			'ftpCP' : releaseDetails.ftpCP,
			'host' : releaseDetails.host,
			'port' : releaseDetails.port,
			'user' : releaseDetails.user,
			'password' : releaseDetails.password,
			'sftp' : releaseDetails.sftp,
		});
		 $scope.removeAdapter = function (adapterIndex) {
			    $scope.adapterDetails.splice(adapterIndex, 1);
			  }
		 
		// $scope.$setPristine(true);
		$scope.PD = {};
	};
	$scope.addCronJob = function(releaseDetails) {
		$scope.cronJobDetails.push({
			'cronJob' : releaseDetails.cronJob,
		});
		 $scope.removeCronJob = function (cronJobIndex) {
			    $scope.cronJobDetails.splice(cronJobIndex, 1);
			  }
		// $scope.$setPristine(true);
		$scope.PD = {};
	};
	
	$scope.jmsPlaceHolderNameName = "Queue Name";
	$scope.connectionFactory = "Queue Connection Factory";
	$scope.queueChecked = function() {
		$scope.jmsPlaceHolderNameName = "Queue Name";
		$scope.connectionFactory = "Queue Connection Factory";
		$scope.apply();
	};

	$scope.topicChecked = function() {
		$scope.jmsPlaceHolderNameName = "Topic Name";
		$scope.connectionFactory = "Topic connection Factory";
		$scope.apply();
	};
	
		
	
	$scope.submitRD =function(){ 
        
         $scope.dataInfo ={  'ticketType':$scope.releaseDetails.ticketType,
        		 			 'ticketNumber':$scope.releaseDetails.ticketNumber,
        		 			'releaseDate':$scope.releaseDetails.releaseDate,
        		 			 'releaseDescription':$scope.releaseDetails.releaseDescription,
        		 			'deployments' : $scope.deploymentDetails,
        		 			 'jmsObjects': $scope.jmsDetails,
							 'dataSourceObjects':$scope.dataSourceDetails,
							 'mdsObjects': $scope.mdsreleaseDetails,
							 'ftpAdapterObject': $scope.adapterDetails,
							 'cronJobs': $scope.cronJobDetails
        		 		}
         $http({
             method : "POST",
             url : 'saveReleaseData',
             data : angular.toJson($scope.dataInfo),
             headers : {
                 'Content-Type' : 'application/json'
             }
         }).then( _success, _error );
     };
     
     function ShowConfirm () {
         if ($window.confirm("Ticket Number "+$scope.releaseDetails.ticketNumber+" Saved Sucessfully.<br> DO you want to enter new Release Details")) {
        	 reloadPage();
         } else { 
        	 $window.location='./rd';
         }
     }
     
     function _success(response) {
    	 ShowConfirm();
     }
     function _error(response) {
    	 console.log(response)
     }
     function reloadPage()                                                
     {
       $window.location.reload();
     }
     
    
     

} ]);
