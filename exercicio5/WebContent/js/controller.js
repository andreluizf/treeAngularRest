(function() {
	'use strict';

	angular.module('treeApp', ['ui.tree']).controller('MainCtrl',
			function($scope, $http) {
				$http({
							method : 'POST',
							url : 'resources/equipe/list',
							headers : {
								'Content-Type' : 'application/json'
							}

						}).success(function(data) {
							console.log(data);
							$scope.listEquipe = data
						});

				$scope.atualizarList = function() {
					$http({
								method : 'POST',
								url : 'resources/equipe/list',
								headers : {
									'Content-Type' : 'application/json'
								}

							}).success(function(data) {
								console.log('atualizou');
								console.log(data);
								$scope.listEquipe = data
							});
				};

				$scope.submitForm = function() {

					$scope.plano.parent = nodeData.id
					if ($scope.userForm.$valid) {
						$http({
									method : 'POST',
									url : 'resources/plano',
									headers : {
										'Content-Type' : 'application/json'
									},
									data : $scope.plano
								}).success(function(data) {
									
									$('#addPlano').modal('hide');
									$scope.atualizarList;

								});
					}

				};

				$scope.selectedItem = {};

				$scope.options = {
					accept : function(sourceNodeScope, destNodesScope,
							destIndex) {
						return false;
					}

				};

				$scope.remove = function(scope) {
					scope.remove();
				};

				$scope.toggle = function(scope) {
					scope.toggle();
				};
				var nodeData;
				$scope.newSubItem = function(scope) {
					$('#addPlano').modal(true);
					nodeData = scope.$modelValue;
					console.log(nodeData);

				};
			});

})();