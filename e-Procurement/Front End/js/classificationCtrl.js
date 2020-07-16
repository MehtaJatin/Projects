var app=angular.module('myApp');
app.controller('classificationCtrl',function($scope,$window,$http,$rootScope,$stateParams,$state)
{
    $scope.searchTender=function()
    {
        $http({
            method:"POST",
            url:"http://localhost:8080/searchbyclassi",
            params:{
                classification:$scope.searchclassification
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