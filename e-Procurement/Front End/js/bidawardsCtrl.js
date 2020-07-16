var app=angular.module('myApp');
app.controller('bidawardsCtrl',function($scope,$filter,$window,$http,$rootScope,$stateParams,$state)
{

    (function()
    {
        
        var d=$filter('date')(new Date(),'yyyy-MM-dd');
        $http({
            method:"POST",
            url:"http://localhost:8080/bidawards",
            params:{
                date:d
            },
            headers : {
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
                $scope.bids=response.data;
            },function()
            {
                alert("Error");
            }
        )


    }());
    
});