var consumeApp = angular.module('consumeApp', ['ngRoute']);

consumeApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'Home',
	}).when('/message', {
		controller : 'MessageController',
	});
}]);



consumeApp.controller('MessageController', function($scope, $http) {
	$http.get('http://localhost:9000/getInfoMessage').then(function(response) {
		    $scope.message = "Message reçu";
	})
});

consumeApp.controller('Home', function($scope) {
		    $scope.message = "Hello From AngularJS";
});