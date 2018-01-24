var app = angular.module('sideBar', ["ui.router"]);

app.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/BemVindo')
    $stateProvider

        .state('home', {
            url: "/BemVindo",
            views: {
                "main": {
                    controller: 'homeCtrl',
                    template: "<p>HOME</p>"
                }
            }
        })
        .state('cadastroCliente', {
            url: "/cadastroCliente",
            views: {
                "main": {
                    controller: 'cadastroClienteCtrl',
                    template: "<p>Cadastro Cliente</p>"
                }
            }
        })
        .state('chat', {
            url: "/chat",
            views: {
                "main": {
                    controller: 'chatCtrl',
                    template: "<p><b>chat</b></p>"
                }
            }
        })
});

app.controller('MainCtrl', function($scope) {

});

app.controller('homeCtrl', function($scope) {

});

app.controller('cadastroClienteCtrl', function($scope) {

});
app.controller('chatCtrl', function($scope) {

});