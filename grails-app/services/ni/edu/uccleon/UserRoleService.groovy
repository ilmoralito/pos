package ni.edu.uccleon

import grails.gorm.transactions.Transactional

@Transactional
class UserRoleService {

    List<Role> userRoles(final User user) {
        UserRole.where { user == user }.list().role
    }
}
