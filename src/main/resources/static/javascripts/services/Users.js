
angular.module('UsersService', ['UsersService']).factory('users',
    ['$resource', function($resource) {

    return $resource('', {}, {
        getUserList: {method: 'GET', url: '/users/userlist', isArray: true},
        addUser: {method: 'POST', url: '/users/adduser'},
        deleteUser: {method: 'DELETE', params: {id: '@id'}, url: '/users/deleteuser/:id'}
        });
}]);
