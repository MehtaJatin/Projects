var app=angular.module("myApp");
app.controller('misCtrl',function($scope,$window,$http,$rootScope,$stateParams,$state)
{
    $scope.back=function()
    {
        $state.transitionTo('home');
    }
    
    $scope.adminlogin=function()
    {
        if(($scope.uadmin=="admin")&&($scope.upassword=="admin"))
        {
            $state.transitionTo('adminportal');
        }
        else
        {
            $scope.uadmin="";
            $scope.upassword="";
            alert("Invalid User/Password");
        }
    }

});