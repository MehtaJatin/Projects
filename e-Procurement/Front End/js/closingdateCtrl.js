var app=angular.module("myApp");
app.controller('closingdateCtrl',function($scope,$filter,$window,$http,$rootScope,$stateParams,$state)
{
    $scope.searchByClosingDate=function()
    {
        var d=$filter('date')($scope.closedate,'yyyy-MM-dd');
        $http({
            method:"POST",
            url:"http://localhost:8080/searchbydate",
            params:{
                date:d
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

    }
});