var app=angular.module('myApp');
app.controller('biddingCtrl',function($scope,$window,$http,$rootScope,$stateParams,$state,$cookies)
{
    app.run(function($rootScope,$location,$state,$cookies)
    {
        if($cookies.get('userinfo'))
           {
               alert("Login First")
               $state.transitionTo('home');
           }      
    });
   

    $scope.userInfo=$cookies.get('userinfo');
    $scope.bidten=$cookies.get('bidtender');
    
        
    $scope.bid=function()
    {
        
        var d={};
        d.tendervender=$scope.tenderinfo.tenderid+$scope.venderinfo.email;
        d.tenderid=$scope.tenderinfo.tenderid;
        d.venderid=$scope.venderinfo.email;
        d.bidvalue=$scope.bidvalue;
        d.closingdate=$scope.tenderinfo.closingdate;

        if(parseInt($scope.bidvalue)<=parseInt($scope.tenderinfo.base))
        {
            alert("Wrong Bid");
        }
        else
        {

            $http({
                method:"POST",
                url:"http://localhost:8080/registerBid",
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
                    alert("Oops!! You were already bid for this tender. :)");
                }
            )
        }
    };


    (function()
    {
        $http({
            method:"POST",
            url:"http://localhost:8080/searchbytenderid",
            params:{
                ser : $cookies.get("bidtender")
            },
            headers : {
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
                $scope.tenderinfo=response.data;
            },function()
            {
                alert("Error");
            }
        )

    }());

    (function()
    {
        $http({
            method:"POST",
            url:"http://localhost:8080/searchbyvenderid",
            params:{
                vendername : $cookies.get("userinfo")
            },
            headers : {
                'Accept': 'application/json'
              }
        }).then(
            function(response)
            {
                $scope.venderinfo=response.data;
            },function()
            {
                alert("Error in venderinfo");
            }
        )

    }());
});