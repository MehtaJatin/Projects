var app=angular.module('myApp');
app.controller('cancelCtrl',function($scope,$window,$http,$rootScope,$stateParams,$state)
{
    (function()
    {
        $http({
            method:"POST",
            url:"http://localhost:8080/searchbystatus",
            params:{
                status:"cancel"
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
    }());

});