var app = angular.module('app', []);



app.controller('myctrlp', function($scope, $http) {

	var url = "http://localhost:8080/api/allCourse";
    var config = {
        headers: {
            'Content-Type': 'application/json;charset=utf-8;'
        }};

    $http.get(url,config).then(function(response) {

        if (response.data.status === true) {
            $scope.arrlists =response.data.data;
            $scope.showAllCustomers = true;
        } else {
            $scope.postResultMessage = "get All Customers Data Error!";
        }
    }, function(response) {
        $scope.postResultMessage = response.data.message;
    });


    $scope.checkselection = function () {

        if ($scope.cateSelect !== "" && $scope.cateSelect !== undefined) {
            $scope.postResultMessage = 'Selected Value: ' + $scope.cateSelect;


            $scope.submitForm = function () {

                var url = "http://localhost:8080/api/createReg";
                var config = {
                    headers: {
                        'Content-Type': 'application/json;charset=utf-8;'
                    }
                }

                var data = {
                    dept: $scope.cateSelect,
                    fname: $scope.fname,
                    lname: $scope.lname,
                    email: $scope.email,
                    mobile: $scope.mobile,
                    gender: $scope.gender,
                    age: $scope.age,
                    city: $scope.city,
                    avatar: $scope.avatar
                };

                $http.post(url, data, config).then(function (response) {
                    $scope.postResultMessage = response.data.message;
                }, function (response) {
                    $scope.postResultMessage = "Fail!";
                });


                $scope.fname = "";
                $scope.lname = "";
                $scope.email = "";
                $scope.mobile = "";
                $scope.age = "";
                $scope.gender = "";
                $scope.city = "";
                $scope.avatar = "";

            }
        }
        else
            $scope.postResultMessage = 'Please Select Course';
        }
});

app.controller('myctrl', function($scope, $http) {
	
	$scope.showAllCustomers = false;

		//var url = $location.absUrl() + "/allStudent";
		var url = "http://localhost:8080/api/allStudent";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		};


       $http.get(url,config).then(function(response) {

			if (response.data.status === true) {
             //   $scope.getResultMessage = response.data.mess;
				$scope.allStudent = response.data.data;
				$scope.showAllCustomers = true;

			} else {
				$scope.getResultMessage = "get All Customers Data Error!";
			}

		}, function(response) {
           $scope.getResultMessage = response.data.mess;
		});


});


/*
app.controller('getcustomerControllerrollNo', function($scope, $http, $location) {
	
	$scope.showCustomer = false;
	
	$scope.getCustomer = function() {
		var url = $location.absUrl() + "api/findByRollNo/"+ $scope.rollNo;
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {


            if (response.data.status === true) {
                $scope.getResultMessage = response.data.mess;
				$scope.allData = response.data;
                $scope.showCustomer = true;

            } else {
				$scope.getResultMessage = "rollNo Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});



app.controller('getcustomersbylastnameController', function($scope, $http, $location) {
	
	$scope.showCustomersByLastName = false;
	
	$scope.getCustomersByLastName = function() {
		var url = $location.absUrl() + "api/findByrRollNo";

		var config = {
			headers : {	'Content-Type' : 'application/x-www-form-urlencoded;' },
			params: { 'rollNo' : $scope.rollNo }
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.allcustomersbylastname = response.data;
				$scope.showCustomersByLastName = true;

			} else {
				$scope.getResultMessage = "Customer Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});

*/
