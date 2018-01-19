/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("HelpApp", [])
        .value('urlBase', 'http://localhost:8080/DesafioConductor/rest/')
        .controller("ClienteController", function ($http, urlBase) {
            var self = this;

            self.ListaClientes = [];
            self.cl = undefined;

            //cliente deixa de ser indefino para se tornar uma lista vazia.
            self.novo = function () {
                self.cl = {};
            };

            //Se o cliente a ser salvo for novo, ou seja, se não tiver um ID, entra na condição POST.
            //Caso ja tenha um ID, ele já é existente no BD e apenas será atualizado, então será feito um PUT.
            self.salvar = function () {
                var metodo = 'POST';
//                if (self.cl.id) {
//                    metodo = 'PUT';
//                }

                $http({
                    method: metodo,
                    url: urlBase + 'cliente/',
                    data: self.cl
                }).then(function successCallback(response) {
                    self.atualizarTabela();
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            //cliente deixa de ser indefino, torna-se um cliente existente para ser alterado. Depois exige o botão salvar.
            self.alterar = function (cl) {
                self.cl = cl;
            };

//            self.concluir = function (cl) {
//                self.cl = cl;
//
//                $http({
//                    method: 'PUT',
//                    url: urlBase + 'cliente/' + self.cl.id + '/'
//                }).then(function successCallback(response) {
//                    self.atualizarTabela();
//                }, function errorCallback(response) {
//                    self.ocorreuErro();
//                });
//            };

            self.ocorreuErro = function () {
                alert("Ocorreu um erro inesperado!");
            };

            self.atualizarTabela = function () {
                $http({
                    method: 'GET',
                    url: urlBase + 'cliente/'
                }).then(function successCallback(response) {
                    self.listaClientes = response.data;
                    self.cl = undefined;
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };
            self.pesquisa = function () {
                var metodo = 'POST';
               
                $http({
                    method: 'GET',
                    url: urlBase + 'cliente/' + /*self.cl.id*/2 + '/'});
            };
//                }).then(function successCallback(response) {
//                    self.atualizarTabela();
//                }, function errorCallback(response) {
//                    self.ocorreuErro();
//                });
//            };

            self.activate = function () {
                self.atualizarTabela();
            };
            self.activate();
});
