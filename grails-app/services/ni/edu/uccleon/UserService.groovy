package ni.edu.uccleon

import grails.gorm.services.Service

interface IUserService {

    List<User> list()

    User find(final Serializable id)

    User delete(final Serializable id)

    User restorePassword(final Serializable id)

    User save(final String username, final String fullName, final List<String> authorityList)

    User update(final Serializable id, final String username, final String fullName, final Boolean enabled, final List<String> authorityList)
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
    User save(final String username, final String fullName, final List<String> authorityList) {
        User user = new User(
            username: username,
            fullName: fullName
        ).save(failOnError: true)

        createUserRole(authorityList, user)

        user
    }

    @Override
    User update(final Serializable id, final String username, final String fullName, final Boolean enabled, final List<String> authorityList) {
        User user = find(id)

        if (user) {
            user.username = username
            user.fullName = fullName
            user.enabled = enabled

            UserRole.removeAll(user)

            createUserRole(authorityList, user)

            user.save(failOnError: true)
        }

        user
    }

    private void createUserRole(final List<String> authorityList, final User user) {
        authorityList.each { authority ->
            Role role = Role.findByAuthority(authority)

            if (role) {
                UserRole.create(user, role, true)
            }
        }
    }
}
