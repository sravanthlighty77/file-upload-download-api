/**
 * 
 */

var URI = "http://localhost:8080/notes";

var application = angular.module('NotesApplication',["ngRoute"]);
application.controller('NotesController', function($scope, $http){
	$scope.notesList = {};
	$scope.message = null;
	$scope.note = {};
	$scope.updateNote = {};
	$scope.note.title = null;
	$scope.note.description = null;
	$scope.note.id = null;
	$scope.updateNote.title = null;
	$scope.updateNote.description = null;
	$scope.updateNote.id = null;
	$scope.searchValue = "";
	$scope.uploadFile = null;
	
	/** Get Notes List */ 
	$http.get( URI + "/list" ).then(function(response){
		$scope.notesList = response.data;
		$scope.message = null;
	}, function(response){
		$scope.message = response.data.message;
		$scope.notesList = null;
	});
	
	$scope.update = function(note,id){
		$scope.updateNote.title = note.title;
		$scope.updateNote.description = note.description;
		$scope.updateNote.id = id;
		$scope.note = {};
		
	}
	
	$scope.deleteNote = function(id){
		$http.delete( URI + "/delete/" +id).then(function(response){
			$scope.notesList = response.data;
			$scope.message = null;
			$scope.note = {};
			
		}, function(){
			$scope.note = null;
			$scope.message = 'Notes Failed to Add';
		})
	}
	
	$scope.updateNotes = function(){
		alert($scope.updateNote);
		let data = angular.toJson($scope.updateNote);
		$http.put( URI + "/update", data).then(function(response){
			$scope.notesList = response.data;
			$scope.message = null;
			$scope.updateNote = {};
			
		}, function(){
			$scope.note = null;
			$scope.message = 'Notes Failed to Add';
		})
	}
	
	$scope.showUpload = function(){
		let file = document.getElementById('uploadFile').files[0];
		let formData = new FormData();
		formData.append("file", file, file.name);
		
		var config = {
		           transformRequest: angular.identity,
		           transformResponse: angular.identity,
		         headers : {
		           'Content-Type': undefined
		           }
		       }
		
		$http.post("http://localhost:8080/notes/fileUpload", formData, config
		).then(function(response){
			$scope.message = response.data;
		}, function(response){
			$scope.message = 'file failed to uplaod';
		});
	}
	
	$scope.search = function(){
		if($scope.searchValue == ""){
			$http.get("http://localhost:8080/notes/list").then(function(response){
				$scope.notesList = response.data;
				$scope.message = null;
			}, function(response){
				$scope.message = response.data.message;
				$scope.notesList = null;
			});
		}else{
			$http.get(URI + "/search/" + $scope.searchValue).then(function(response){
				$scope.notesList = response.data;
				$scope.message = null;
			}, function(response){
				$scope.message = response.data.message;
				$scope.notesList = null;
			});
		}
		
		
	}
	
	
	$scope.addNote = function(){
		let data = angular.toJson($scope.note);
		$http.post(URI + "/add",data).then(function(response){
			$scope.notesList = response.data;
			$scope.message = null;
			$scope.note = {};
			
		}, function(response){
			$scope.note = null;
			$scope.message = 'Notes Failed to Add';
		})
	}
});