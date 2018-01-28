package ni.edu.uccleon.user

import grails.validation.ValidationException
import ni.edu.uccleon.UserRoleService
import ni.edu.uccleon.UserService
import ni.edu.uccleon.RoleService
import ni.edu.uccleon.User

class UserController {

    UserRoleService userRoleService
    UserService userService
    RoleService roleService

    static allowedMethods = [
        save: 'POST',
        update: 'PUT',
        updateProfile: 'PUT',
        updatePassword: 'PUT',
        restorePassword: 'PUT'
    ]

    def index() {
        respond userService.list()
    }

    def show(final Long id) {
        User user = userService.find(id)

        if (!user) response.sendError 404

        respond user, model: [userRoleList: userRoleService.userRoles(user)]
    }

    def create() {
        respond new User(params), model: [roleList: roleService.list()]
    }

    def save(final SaveUserComand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors] , model: [roleList: roleService.list()], view: 'create')
            return
        }

        try {
            User user = userService.save(command)

            flash.message = 'Usuario creado'
            redirect user
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [roleList: roleService.list()], view: 'create')
        }
    }

    def edit(final Long id) {
        User user = userService.find(id)

        respond user, model: [
            roleList: roleService.list(),
            userRoleList: userRoleService.userRoles(user)
        ]
    }

    def update(final UpdateUserComand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], model: [user: userService.find(command.id), roleList: roleService.list()], view: 'edit')
            return
        }

        try {
            User user = userService.update(command)

            flash.message = 'Usuario actualizado'
            redirect user
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [roleList: roleService.list()], view: 'edit')
        }
    }

    def restorePassword(final Long id) {
        User user = userService.restorePassword(id)

        flash.message = 'Clave de paso restaurada'
        redirect user
    }

    def profile() {
        respond authenticatedUser
    }

    def updateProfile(SaveUserProfileCommand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], model: [user: authenticatedUser], view: 'profile')

            return
        }

        try {
            User user = authenticatedUser

            user.properties = command.properties

            user.save(flush: true)

            flash.message = 'Perfil actualizado'
            redirect uri: '/secure/users/profile', method: 'GET'
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [user: authenticatedUser], view: 'profile')
        }
    }

    def password() {}

    def updatePassword(final UpdatePasswordCommand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], view: 'password')
            return
        }

        command.updatePassword()

        flash.message = 'Clave actualizada'
        redirect uri: '/secure/users/password'
    }
}
