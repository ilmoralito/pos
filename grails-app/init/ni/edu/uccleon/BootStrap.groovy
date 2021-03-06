package ni.edu.uccleon

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            development()
        }

        if (Environment.current == Environment.PRODUCTION) {
            production()
        }
    }
    def destroy = {
    }

    private void development() {
        // ROLES
        Role chefRole = Role.findByAuthority('ROLE_CHEF') ?: new Role(authority: 'ROLE_CHEF').save(failOnError: true)
        Role waiterRole = Role.findByAuthority('ROLE_WAITER') ?: new Role(authority: 'ROLE_WAITER').save(failOnError: true)
        Role managerRole = Role.findByAuthority('ROLE_MANAGER') ?: new Role(authority: 'ROLE_MANAGER').save(failOnError: true)
        Role cashierRole = Role.findByAuthority('ROLE_CASHIER') ?: new Role(authority: 'ROLE_CASHIER').save(failOnError: true)
        Role bartenderRole = Role.findByAuthority('ROLE_BARTENDER') ?: new Role(authority: 'ROLE_BARTENDER').save(failOnError: true)
        Role administratorRole = Role.findByAuthority('ROLE_ADMINISTRATOR') ?: new Role(authority: 'ROLE_ADMINISTRATOR').save(failOnError: true)

        // USERS
        User chefUser = User.findByUsername('chef') ?: new User(username: 'chef', fullName: 'Chef Name', password: 'temporal').save(failOnError: true)
        User waiterUser = User.findByUsername('waiter') ?: new User(username: 'waiter', fullName: 'Waiter Name', password: 'temporal').save(failOnError: true)
        User managerUser = User.findByUsername('manager') ?: new User(username: 'manager', fullName: 'Manager Name', password: 'temporal').save(failOnError: true)
        User cashierUser = User.findByUsername('cashier') ?: new User(username: 'cashier', fullName: 'Cashier Name', password: 'temporal').save(failOnError: true)
        User bartenderUser= User.findByUsername('bartender') ?: new User(username: 'bartender', fullName: 'Bartender Name', password: 'temporal').save(failOnError: true)
        User administratorUser = User.findByUsername('administrator') ?: new User(username: 'administrator', fullName: 'Administartor Name', password: 'temporal').save(failOnError: true)

        // USER ROLE
        if (!UserRole.exists(chefUser.id, chefRole.id)) {
            UserRole.create chefUser, chefRole
        }

        if (!UserRole.exists(waiterUser.id, waiterRole.id)) {
            UserRole.create waiterUser, waiterRole
        }

        if (!UserRole.exists(managerUser.id, managerRole.id)) {
            UserRole.create managerUser, managerRole
        }

        if (!UserRole.exists(bartenderUser.id, bartenderRole.id)) {
            UserRole.create bartenderUser, bartenderRole
        }

        if (!UserRole.exists(cashierUser.id, cashierRole.id)) {
            UserRole.create cashierUser, cashierRole
        }

        if (!UserRole.exists(administratorUser.id, administratorRole.id)) {
            UserRole.create administratorUser, administratorRole
        }

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        // TABLES
        Table table1 = Table.findByNumber(1) ?: new Table(number: 1).save(failOnError: true)
        Table table2 = Table.findByNumber(2) ?: new Table(number: 2).save(failOnError: true)
        Table table3 = Table.findByNumber(3) ?: new Table(number: 3).save(failOnError: true)
        Table table4 = Table.findByNumber(4) ?: new Table(number: 4).save(failOnError: true)
        Table table5 = Table.findByNumber(5) ?: new Table(number: 5).save(failOnError: true)
        Table table6 = Table.findByNumber(6) ?: new Table(number: 6).save(failOnError: true)
    }

    private void production() {
    }
}
