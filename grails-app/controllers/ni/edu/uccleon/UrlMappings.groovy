package ni.edu.uccleon

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
            }
        }

        '/'(controller: 'login', action: 'auth')

        '/logout'(controller: 'logout')

        group '/secure', {
            // DASHBOARD
            '/dashboard'(controller: 'dashboard', action: 'index')

            // USER
            '/users'(resources: 'user', excludes: ['delete']) {
                collection {
                    '/restorePassword'(controller: 'user', action: 'restorePassword', method: 'PUT')
                }
            }

            // TABLES
            '/tables'(resources: 'table', excludes: ['delete'])

            // CATEGORY
            '/categories'(resources: 'category', excludes: ['delete'])

            // ITEMS
            '/items'(resources: 'item', excludes: ['delete'])

            // MENU
            get "/menu/$categoryName?"(controller: 'menu', action: 'index')
        }

        // USERS
        get '/secure/users/profile'(controller: 'user', action: 'profile')
        put '/secure/users/update/profile'(controller: 'user', action: 'updateProfile')
        get '/secure/users/password'(controller: 'user', action: 'password')
        put '/secure/users/update/password'(controller: 'user', action: 'updatePassword')

        '500'(view:'/error')
        '404'(view:'/notFound')
    }
}
