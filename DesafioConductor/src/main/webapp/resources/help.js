/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("HelpApp", [])
        .value('urlBase', 'http://localhost:8080/DesafioConductor/rest/')
        .controller("ClienteController", function ($http, urlBase)
{
            var self = this;

            self.clientes = [];
            self.cliente = undefined;

            //cliente deixa de ser indefino para se tornar uma lista vazia.
            self.novo = function () {
                self.cliente = {};
            };

            //Se o cliente a ser salvo for novo, ou seja, se não tiver um ID, entra na condição POST.
            //Caso ja tenha um ID, ele já é existente no BD e apenas será atualizado, então será feito um PUT.
            self.salvar = function () {
                var metodo = 'POST';
                if (self.cliente.id) {
                    metodo = 'PUT';
                }

                $http({
                    method: metodo,
                    url: urlBase + 'cliente/',
                    data: self.cliente
                }).then(function successCallback(response) {
                    self.atualizarTabela();
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            //cliente deixa de ser indefino, torna-se um cliente existente para ser alterado. Depois exige o botão salvar.
            self.alterar = function (cliente) {
                self.cliente = cliente;
            };

            self.ocorreuErro = function () {
                alert("Ocorreu um erro inesperado!");
            };

            self.atualizarTabela = function () {
                $http({
                    method: 'GET',
                    url: urlBase + 'cliente/'
                }).then(function successCallback(response) {
                    self.clientes = response.data;
                    self.cliente = undefined;
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.activate = function () {
                self.atualizarTabela();
            };
            self.activate();
});
