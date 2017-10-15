grails {
    plugin {
        springsecurity {
            securityConfigType = 'InterceptUrlMap'

            userLookup {
                userDomainClassName = 'ni.edu.uccleon.User'
                authorityJoinClassName = 'ni.edu.uccleon.UserRole'
            }

            authority {
                className = 'ni.edu.uccleon.Role'
            }

            logout {
                afterLogoutUrl = '/'
            }

            successHandler {
                defaultTargetUrl = '/secure/dashboard'
            }

            staticRules {
                chainMap = [
                    [pattern: '/assets/**',      filters: 'none'],
                    [pattern: '/**/js/**',       filters: 'none'],
                    [pattern: '/**/css/**',      filters: 'none'],
                    [pattern: '/**/images/**',   filters: 'none'],
                    [pattern: '/**/favicon.ico', filters: 'none'],
                    [pattern: '/**',             filters: 'JOINED_FILTERS']
                ]
            }

            interceptUrlMap = [
                [pattern: '/',                                          access: ['permitAll']],
                [pattern: '/error',                                     access: ['permitAll']],
                [pattern: '/index',                                     access: ['permitAll']],
                [pattern: '/index.gsp',                                 access: ['permitAll']],
                [pattern: '/shutdown',                                  access: ['permitAll']],
                [pattern: '/assets/**',                                 access: ['permitAll']],
                [pattern: '/**/js/**',                                  access: ['permitAll']],
                [pattern: '/**/css/**',                                 access: ['permitAll']],
                [pattern: '/**/images/**',                              access: ['permitAll']],
                [pattern: '/**/favicon.ico',                            access: ['permitAll']],
                [pattern: '/login/**',                                  access: ['permitAll']],
                [pattern: '/logout',                                    access: ['permitAll']],
                [pattern: '/logout/**',                                 access: ['permitAll']],

                // DASHBOARD
                [pattern: '/secure/dashboard',                          access: ['ROLE_MANAGER', 'ROLE_ADMINISTRATOR']],

                // USERS
                [pattern: '/secure/users/**',                           access: ['ROLE_MANAGER']],

                // TABLES
                [pattern: '/secure/tables/**',                          access: ['ROLE_MANAGER', 'ROLE_ADMINISTRATOR']],

                // CATEGORIES
                [pattern: '/secure/categories/**',                      access: ['ROLE_MANAGER', 'ROLE_ADMINISTRATOR']],

                // ITEMS
                [pattern: '/secure/items/**',                           access: ['ROLE_MANAGER', 'ROLE_ADMINISTRATOR']],
            ]
        }
    }
}
