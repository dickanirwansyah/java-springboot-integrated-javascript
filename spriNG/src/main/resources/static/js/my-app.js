var myapp = angular.module('myapp', ['ngRoute']);

//konfigurasi router
myapp.config(function($routeProvider){

    $routeProvider
        .when('/category', {
            templateUrl: 'page/category.html',
            controller: 'mainController'
        })

        .when('/phone', {
            templateUrl: 'page/phone.html',
            controller: 'phoneController'
        });
});

//phone.html
myapp.controller('phoneController', function($scope){

    $scope.message = 'Hello Phone Page !';

});

//category.html
myapp.controller('categoryController', function($scope, $http){

    $scope.title = "Data Category"

    $scope.openCategory = function(){
        $scope.selectedCategory = null;
    }

    function getListCategory(){

        $http.get('/api/category/').success(function(data){

            $scope.categorys = data;
        });
    }

    getListCategory();

    $scope.updateCategory = function(data){
        console.log("idcategory : "+data.idcategory+" | name: "+data.name);
        $scope.selectedCategory = data;
    }

    $scope.simpanCategory = function(response){
        console.log("successfully");
        $http.post('/api/category/created', $scope.selectedCategory).then(success, failed);

        function success(response){
            getListCategory();
            console.log(response);
            $("#formCategory").modal('hide');
            alert('data has been saved !');
        }

        function failed(response){
            console.log(response);
            $("#formCategory").modal('hide');
            alert('failed to saved !');
        }
    }

    $scope.updatedCategory = function(){
        console.log("successfuly");
        $http.post('/api/category/updated', $scope.selectedCategory).then(success, failed);

        function success(response){
            getListCategory();
            console.log(response);
            $("#formCategory").modal('hide');
            alert('data has been saved !');
        }

        function failed(response){
            console.log(response);
            $("#formCategory").modal('hide');
            alert('failed to saved !');
        }
    }

});


//index.html
myapp.controller('mainController', function($scope){

    $scope.message = 'Hello First Page !';

});