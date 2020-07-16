var app=angular.module('myApp');
app.controller('enrollmentCtrl',function($scope,$window,$http,$rootScope,$stateParams,$state)
{
    $scope.register=function()
    {
        var d=$scope.vender;
        $http({
            method:"POST",
            url:"http://localhost:8080/registerVender",
            data:JSON.stringify(d),
           headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
               alert(response.data.res);
               $state.transitionTo('home');   
            },function(response)
            {
                alert("Error");
            }
        )

        /*if(loginservice.login($scope.user,$scope.password))
        {
            $rootScope.userName=$scope.user;
            $scope.message='';
            $scope.user='';
            $scope.password='';
            $state.transitionTo('home');
        }
        else
        {
        $scope.message="Incorrect user/pass !!";
        }*/
    };
    
});