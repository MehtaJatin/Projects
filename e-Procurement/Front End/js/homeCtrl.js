var app=angular.module('myApp');
app.controller('homeCtrl',function($scope,$filter,$http,$rootScope,$stateParams,$state,$cookies)
{
    $scope.signup=function()
    {
        $state.transitionTo('enrollment');
      
    };
    
    $scope.login=function()
    {
        
        $http({
            method:"POST",
            url:"http://localhost:8080/findVender",
            params : {
                user: $scope.user,
                password: $scope.password
            }
           /* headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
              }*/
        }).then(
            function(response)
            {
                if(response.data.str!="Failed")  
                {
                    alert(response.data.res);
                    $cookies.put('userinfo',response.data.res);
                }
                else
                {
                    alert(response.data.res);
                    
                }     
            },function(response)
            {
                alert("Error");
            }
        )

        /*if(loginservice.login($scope.user,$scope.password))
        {
            $rootScope.userName=$scope.user;
            $scope.message='';
            $scope.user='';
            $scope.password='';
            $state.transitionTo('home');
        }
        else
        {
        $scope.message="Incorrect user/pass !!";
        }*/
    };
     
    $scope.loggeduser=function()
    {
        if($cookies.get('userinfo'))
        {
            $scope.userinfo=$cookies.get('userinfo');
            return true;
        }
        else
        return false;
    };

    $scope.bid=function(t)
    {
        if($cookies.get('userinfo'))
          { 
              $cookies.put('bidtender',t.tenderid);
              $state.transitionTo('bidding');
          }
        else
           alert("Login first");
    };

    $scope.logout=function()
    {
        $cookies.put('userinfo',"");
        $cookies.put('bidtender',"");
        alert("Logged out Successfully");
    };

    $scope.searchtender=function()
    {
       $rootScope.sid=$scope.searchid;
       $state.transitionTo('searchtender');

    };
    
    (function(){

     var d=$filter('date')(new Date(),'yyyy-MM-dd');
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

    }());
    
});