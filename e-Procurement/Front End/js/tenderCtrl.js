var app=angular.module('myApp');
app.controller('tenderCtrl',function($scope,$filter,$window,$http,$rootScope,$stateParams,$state)
{
    $scope.tenderRegister=function()
    {
        //$scope.tender.publishdate=$filter('date')(date[$scope.tender.publishdate, "yyyy/MM/dd"]);
        $scope.tender.publishdate=$filter('date')($scope.tender.publishdate, 'yyyy-MM-dd');
        $scope.tender.opendate=$filter('date')($scope.tender.opendate, 'yyyy-MM-dd');
        $scope.tender.closingdate=$filter('date')($scope.tender.closingdate, 'yyyy-MM-dd');
        var d=$scope.tender;
        $http({
            method:"POST",
            url:"http://localhost:8080/registerTender",
            data:JSON.stringify(d),
           headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
               alert(response.data.res);
               $state.transitionTo('adminportal');   
            },function(response)
            {
                alert("Error in tender register");
            }
        )
    };
    $scope.updatetender=function()
    {
        //$scope.tender.publishdate=$filter('date')(date[$scope.tender.publishdate, "yyyy/MM/dd"]);
        var d=$scope.up;
        $http({
            method:"POST",
            url:"http://localhost:8080/registerTender",
            data:JSON.stringify(d),
           headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
               alert(response.data.res);
               $scope.sertender="";
               $scope.sh=false;
               //$state.transitionTo('home');   
            },function(response)
            {
                alert("Error in update");
                $scope.sh=false;
            }
        )
    };
    $scope.searchupdate=function()
    {
        $scope.sh=true;
         $http(
             {
                method:"POST",
                url:"http://localhost:8080/searchbyid",
                params:{
                      ser:$scope.sertender
                }
                 }).then(function(response)
                { 
                    $scope.up=response.data;
                },function(response)
                {
                  alert("Error in search");
                  $scope.sh=false;
                 })
    };
    $scope.deltender=function()
    {
        $http(
            {
                method:"DELETE",
                url:"http://localhost:8080/delTender",
                params:{
                      del:$scope.sertender
                }
            }).then(
                function(response)
                {
                    alert("Deleted Successfully");
                    $scope.sertender="";
                    $scope.sh=false;
                },function(response)
                {
                   alert("Error Deleted");
                }
            )

    };

});