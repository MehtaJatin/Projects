var app=angular.module("myApp");
app.controller('adminportalCtrl',function($scope,$filter,$window,$http,$rootScope,$stateParams,$state)
{
    (function(){
        $http({
            method:"POST",
            url:"http://localhost:8080/alltender",
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

    $scope.enableEdit=function()
    {
        if($scope.edit)
        {
            $scope.edit=false;
        }
        else
        {
            $scope.edit=true;
        }
    }
    $scope.updatetender=function(t)
    {
        //$scope.tender.publishdate=$filter('date')(date[$scope.tender.publishdate, "yyyy/MM/dd"]);
        var d=t;
        d.publishdate=$filter('date')(d.publishdate, 'yyyy-MM-dd');
        d.opendate=$filter('date')(d.opendate, 'yyyy-MM-dd');
        d.closingdate=$filter('date')(d.closingdate, 'yyyy-MM-dd');
        
        $http({
            method:"POST",
            url:"http://localhost:8080/registerTender",
            data:JSON.stringify(t),
           headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
               alert(response.data.res);
               
               //$state.transitionTo('home');   
            },function(response)
            {
                alert("Error in update");
            }
        )
    };
    $scope.deltender=function(t)
    {
        $http(
            {
                method:"DELETE",
                url:"http://localhost:8080/delTender",
                params:{
                      del:t,
                }
            }).then(
                function(response)
                {
                    alert("Deleted Successfully");
                    window.location.reload();
                },function(response)
                {
                   alert("Error in Deletion");
                }
            )

    };

    $scope.tRegister=function()
    {
        $state.transitionTo('tender');
    }
});