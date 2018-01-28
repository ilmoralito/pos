package ni.edu.uccleon

import ni.edu.uccleon.Menu

class CommandController {

    Menu menu

    static defaultAction = 'menu'

    def menu(final String categoryName) {
        respond menu.create(categoryName)
    }

    def create(final Integer table) {
        render params
    }
}
