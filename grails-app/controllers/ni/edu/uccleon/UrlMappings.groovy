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

            // ORDER
            "/orders/barra/$type"(controller: 'order', action: 'index', method: 'GET')

            // USER
            '/users'(resources: 'user', excludes: ['delete'])
            "/users/restore/password/$id"(controller: 'user', action: 'restorePassword', method: 'PUT')
            '/users/profile'(controller: 'user', action: 'profile', method: 'GET')
            '/users/update/profile'(controller: 'user', action: 'updateProfile', method: 'PUT')
            '/users/password'(controller: 'user', action: 'password', method: 'GET')
            '/users/update/password'(controller: 'user', action: 'updatePassword', method: 'PUT')

            // TABLES
            '/tables'(resources: 'table', excludes: ['delete'])
            '/tables/list'(controller: 'table', action: 'list', method: 'GET')

            // CATEGORY
            '/categories'(resources: 'category', excludes: ['delete'])

            // ITEMS
            '/items'(resources: 'item', excludes: ['delete'])

            // CURSTOMERS
            '/customers'(resources: 'customer')

            // MENU
            get "/menu/$categoryName?"(controller: 'menu', action: 'index')
        }

        // ORDER
        '/secure/orders'(resources: 'order', excludes: ['create']) {
            '/details'(resources: 'orderDetail', excludes: ['create']) {
                collection {
                    '/menu'(controller: 'orderDetail', action: 'menu', method: 'GET')
                }
            }
        }

        '500'(view:'/error')
        '404'(view:'/notFound')
    }
}
