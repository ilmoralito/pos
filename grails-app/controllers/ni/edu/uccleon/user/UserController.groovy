package ni.edu.uccleon.user

import grails.validation.ValidationException
import ni.edu.uccleon.UserRoleService
import ni.edu.uccleon.UserService
import ni.edu.uccleon.RoleService
import ni.edu.uccleon.User

class UserController {

    @Autowired UserRoleService userRoleService
    @Autowired UserService userService
    @Autowired RoleService roleService

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
            User user = userService.save(command.username, command.fullName, command.authorityList)

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
            User user = userService.update(command.id, command.username, command.fullName, command.enabled, command.authorityList)

            flash.message = 'Usuario actualizado'
            redirect user
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [roleList: roleService.list()], view: 'edit')
        }
    }

    def restorePassword(final Long userId) {
        User user = userService.restorePassword(userId)

        if (!user) {
            notFound(userId)
            return
        }

        flash.message = 'Clave de paso restaurada'
        redirect user
    }

    def profile() {
        respond authenticatedUser
    }

    def updateProfile() {
        try {
            User user = authenticatedUser

            user.properties = params

            user.save(failOnError: true)

            flash.message = 'Perfil actualizado'
            redirect uri: '/secure/users/profile', method: 'GET'
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [user: authenticatedUser], view: 'profile')
        }
    }

    def password() {
    }

    def updatePassword(final UpdatePasswordCommand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], view: 'password')
            return
        }

        command.updatePassword()

        flash.message = 'Clave actualizada'
        redirect uri: '/secure/users/password'
    }

    private void notFound(final Long userId) {
        flash.message = "El usuario con id $userId no se ha encontrado"

        redirect uri: '/secure/users', method: 'GET'
    }
}
