var app = angular.module("myapp", []);

app.controller("SearchReleaseDetailsController", [ '$scope','$http','$window', function($scope,$http,$window) {
	
	$scope.searchRD =function(){ alert($scope.releaseDetails.ticketNumber);
    
    $http({
        method : "POST",
        url : 'viewReleaseDetails',
        data : $scope.releaseDetails.ticketNumber,
        headers : {
            'Content-Type' : 'application/json'
        }
    }).then( _success, _error );
};

function _success(response) {
   alert("response ="+response);
   //$scope.employees = response.data;
}

function _error(response) {
	 console.log(response.statusText);
}

$scope.OpenPopupWindow = function (releaseId) {
    var $popup = $window.open("editReleaseDetails?releaseDetailsId=" + encodeURIComponent(releaseId), "popup", "width=700,height=450,left=80,top=100");
    $popup.Name = "Window...";
}


$scope.editRD =function(releaseId){ alert(releaseId);
	window.location = "addRD?releaseID=" + encodeURIComponent(releaseId);
     
 };
 
 
 

} ]);
