var app=angular.module('myApp');
app.controller('searchtenderCtrl',function($scope,$window,$http,$rootScope,$stateParams,$state)
{
     
    $scope.searchByTenderId=function()
    {
        $http({
            method:"POST",
            url:"http://localhost:8080/searchbytenderid",
            params:{
                ser : $scope.searchtender
            },
            headers : {
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
                $scope.t=response.data;
                //alert($rootScope.sid);
            },function()
            {
                alert("Error");
            }
        )

    };
   var init=function()
   {
    if($rootScope.sid!="")
    {
        $http({
            method:"POST",
            url:"http://localhost:8080/searchbytenderid",
            params:{
                ser : $rootScope.sid
            },
            headers : {
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
                $rootScope.sid="";
                $scope.t=response.data;
                
            },function()
            {
                $rootScope.sid="";
            }
        )

    }
   }
    /*(function()
    {
        if($rootScope.sid!="")
        {
            $http({
                method:"POST",
                url:"http://localhost:8080/searchbytenderid",
                params:{
                    ser : $rootScope.sid
                },
                headers : {
                    'Accept': 'application/json'
                  }
            }).then(
                function(response)
                {
                    $rootScope.sid="";
                    $scope.t=response.data;
                    
                },function()
                {
                    alert("Error");
                }
            )

        }
    })*/
    init();
});