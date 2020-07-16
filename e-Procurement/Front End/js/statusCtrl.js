var app=angular.module('myApp');
app.controller('statusCtrl',function($scope,$window,$http,$rootScope,$stateParams,$state)
{
    $scope.status=function()
    {
        $http({
            method:"POST",
            url:"http://localhost:8080/searchbystatus",
            params:{
                status:$scope.searchstatus
            },
            headers : {
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
                $scope.tenders=response.data;
            },function()
            {
                alert("Error");
            }
        )
    };

});