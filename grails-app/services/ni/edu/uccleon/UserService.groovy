package ni.edu.uccleon

import ni.edu.uccleon.user.UpdateUserComand
import ni.edu.uccleon.user.SaveUserComand
import grails.gorm.services.Service

interface IUserService {

    List<User> list()

    User find(final Serializable id)

    User delete(final Serializable id)

    User restorePassword(final Serializable id)

    User save(SaveUserComand command)

    User update(UpdateUserComand command)
}

@Service(User)
abstract class UserService implements IUserService {

    @Override
    User restorePassword(final Serializable id) {
        User user = find(id)

        if (user) {
            user.password = 'temporal'

            user.save(failOnError: true)
        }

        user
    }

    @Override
    User save(SaveUserComand command) {
        User user = new User()

        user.properties = command.properties
        user.save(failOnError: true)

        createUserRole(command.roles, user)

        user
    }

    @Override
    User update(UpdateUserComand command) {
        User user = find(command.id)

        if (user) {
            user.properties = command.properties
            user.save(failOnError: true)

            removeUserRoles(user)
            createUserRole(command.roles, user)
        }

        user
    }

    private void removeUserRoles(final User user) {
        UserRole.removeAll(user)
    }

    private void createUserRole(final List<Role> roles, final User user) {
        roles.each { role ->
            UserRole.create(user, role, true)
        }
    }
}
