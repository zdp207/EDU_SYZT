//myTaskDisapatchTaskCtrl.js
ctrls.controller("myTaskDispatchTaskController",['$scope', '$rootScope', 'Teacher', 'Hotreader', 'Class',
	function($scope, $rootScope, Teacher, Hotreader, Class){
		    
        // Initlizate the dropdown statues
        $scope.campusStatuses = [];
        $scope.campusSelected_status = 0;
        
        $scope.gradeStatuses = [];
        $scope.gradeSelected_status = 0;
        
        $scope.classStatuses = [];
        $scope.classSelected_status = 0;
        
        // Get the teacher entity by rootScope id 
        $scope.teacher = Teacher.get({ id: $rootScope.id }, function(){
            
            var gradeName = ['一', '二', '三', '四', '五', '六'];
            var index = 0;
            
            // Get the class by teacher classId
            $scope.class = Class.get({ id: $scope.teacher.classId }, function(){
                $scope.campusStatuses.push({ id: index, name: $scope.class.campusName});
                $scope.gradeStatuses.push({ id: index, name: gradeName[$scope.class.grade - 1] + '年级'});
                $scope.classStatuses.push({ id: index, name: $scope.class.name});
            });
            
        
            // Get the hotreaers pagable by teacher classId
            // The best practice of loadable
            // Create a pageable entity of actions
            $scope.hotreaderLoadable = new Loadable();

            // Set the parameters of loadable
            $scope.hotreaderLoadable.size = 5;
            $scope.hotreaderLoadable.page = 0;

            // Set the $resource arguments like {by: "books"}
            $scope.hotreaderLoadable.arguments = { by: 'clazz', id: $scope.teacher.classId, sortBy: 'id'};

            // Build the loadable object
            $scope.hotreaderLoadable.build(Hotreader);
            
            // Show the first page and append editable to every entity
            $scope.hotreaderLoadable.get();
            
            // Make the checklist model
            $scope.hotreaderLoadable.selected = [];
            
            // Publish the selected entities
            $scope.hotreaderLoadable.publish = function(){
                
                console.log(this.selected);
            };
            
            // The select all method
            $scope.hotreaderLoadable.selectAll = function(selectedAll){
                if (selectedAll) {
                    this.selected = angular.copy(this.roles);
                } else {
                
                }
            };
        });
   
	}]);