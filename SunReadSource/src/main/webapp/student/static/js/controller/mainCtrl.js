//mainCtrl.js
var ctrls = angular.module('nourControllers',['nourConfig', 'ngResource', 'userServices', 'noteServices', 'noteViewServices', 'noteTakeServices', 'paraServices', 'commentServices'
                                             ,'examServices', 'classServices', 'questionServices','reviewServices','joinShelfServices'
                                             ,'bookDetailServices','bookshelfServices','bookshelfViewServices','bookInShelfServices','addbookToShelfServices','dropBookFromShelfServices'
                                             ,'lackFeedbackServices','conditionSearchServices','quickSearchServices','oneBookInShelfServices'
                                             ,'sendMessageServices','getMessageServices','getGiftsServices','getGiftsExNumServices'
                                             ,'weeklyHotServices','monthlyHotServices','yearlyHotServices','weeklyRecommendServices','monthlyRecommendServices','yearlyRecommendServices'
                                             , 'campusServices', 'actionServices', 'pageableServices','loadableServices','hotclazzServices', 'hotreaderServices', 'dropzoneServices', 'ngSanitize', 'semesterServices']);
ctrls.controller("mainController", ['$rootScope', '$scope', 'Student',"Bookshelf", "Note", "Class", "PassExam", 'Action', 'Pageable', 'Hotclazz', 'Hotreader', 'config',
  function ($rootScope, $scope, Student,Bookshelf, Note, Class, PassExam, Action, Pageable, Hotclazz, Hotreader, config) {
    //$rootScope.id = 2;
    //get userid
    $rootScope.id = sessionStorage.getItem("userId");


    //student info``
    Student.get({id : $rootScope.id} ,function(data){
      $scope.picture = {};
      $scope.picture.current = data.picture === ""? "../static/img/myBookshelf/addPhoto.png" : config.IMAGESERVER + data.picture;
      $scope.userInfo = data;
      $rootScope.student = data;
      // Create a classes entitiy
      Class.get({id: $scope.userInfo.clazzId}, function(classData){
        $scope.userInfo.class=classData.name;
        $scope.userInfo.school=classData.campusName;
      });

      // Create a pageable entity of actions
      $scope.actionPageable = new Pageable();

      // Set the parameters of pageable
      $scope.actionPageable.size = 3;

      // Build the pageable object
      $scope.actionPageable.build(Action);

      // Show the page 1
      $scope.actionPageable.showPage(1);

      // Create a Hotreaders entitiy
      $scope.hotReaders={};
      Hotreader.get({by: 'campus', id : data.campusId, page: 0, size: 3 }, function(dataHot){
        dataHot.content[0].picture = dataHot.content[0].picture == "" ? "../static/img/myBookshelf/addPhoto.png" : config.IMAGESERVER + dataHot.content[0].picture;
        $scope.hotReaders.first = dataHot.content[0];
        //$scope.hotReaders.others = dataHot.content;
        $scope.hotReaders.others = dataHot.content.slice(1);
      });
    });

    //bookshelf
    Bookshelf.get({id : $rootScope.id}, function(data){
      $scope.bookshelf = data;
      $scope.bookshelf.finishStatus = 100 * data.readMust / (data.readMust + data.unreadMust);
      })

    //testing
    PassExam.get($rootScope.id, function(data){
      //examDTOs[i].pictureUrl
      for(var i = 0; i < data.examDTOs.length; i++){
        data.examDTOs[i].pictureUrl = data.examDTOs[i].pictureUrl === ""? "../static/img/book.jpg" : config.IMAGESERVER + data.examDTOs[i].pictureUrl;
      }
      $scope.exam = data;
    })

    //note
    Note.get({by: "users", id: $rootScope.id,  page: 0, size: 4, direction: "DESC", sortBy: "creationTime"},
      function(data){
        $scope.notes = data.content;
        for(var i = 0; i < data.content.length; i++){
          $scope.notes[i].bookPictureUrl = $scope.notes[i].bookPictureUrl === ""? "../static/img/book.jpg" : config.IMAGESERVER + $scope.notes[i].bookPictureUrl;
        }
      })

    //hot note
    Note.get({page:0, size: 3, sortBy: 'commentCount', direction: 'DESC'}, function(data){
      $scope.hotNotes = data.content;
    })



  }]);
ctrls.filter('formatImg', function(){
  return function(input){
    if (input == undefined || input == "") {
      return "../static/img/myBookshelf/addPhoto.png";
    };
    return input;
  }
});

ctrls.filter('formatSize4', function(){
  return function(input){
    return input.substring(0, 4) + '...';
  }
});

ctrls.filter('formatSize6', function(){
  return function(input){
    return input.substring(0, 6) + '...';
  }
});

ctrls.filter('formatGender', function(){
 return function(input){
      if (input == 'male') {
        return "男生";
      };
      return "女生";
  }
});

ctrls.filter('formatParagraph', function(){
  return function(data) {
   if (!data) return data;
   return data.replace(/[^\S\n]/g, '&nbsp;').replace(/\n/g, '<br/>');
 };
});