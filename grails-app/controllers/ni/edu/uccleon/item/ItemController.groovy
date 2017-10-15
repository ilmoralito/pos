package ni.edu.uccleon.item

import grails.validation.ValidationException
import ni.edu.uccleon.CategoryService
import ni.edu.uccleon.ItemService
import ni.edu.uccleon.Item

class ItemController {

    @Autowired CategoryService categoryService
    @Autowired ItemService itemService

    static allowedMethods = [ save: 'POST', update: 'PUT' ]

    def index() {
        respond itemService.list()
    }

    def show(final Long id) {
        respond id ? itemService.find(id) : null
    }

    def create() {
        respond new Item(params), model: [categoryList: categoryService.listByEnabled(true)]
    }

    def save(final String name, final Integer price, final String description, final Long categoryId) {
        try {
            Item item = itemService.save(name, price, description, categoryId)

            flash.message = 'Articulo agregado'
            redirect item
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [categoryList: categoryService.listByEnabled(true)], view: 'create')
        } catch(Exception e) {
            flash.message = 'Parametro <category> es requerido'

            redirect uri: '/secure/dashboard', method: 'GET'
        }
    }

    def edit(final Long id) {
        Item item = id ? itemService.find(id) : null

        respond item, model: [categoryList: categoryService.listByEnabled(true)]
    }

    def update(final Long id, final String name, final Integer price, final String description, final Boolean enabled, final Long categoryId) {
        try {
            Item item = itemService.update(id, name, price, enabled ?: false, description, categoryId)

            flash.message = 'Articulo actualizado'
            redirect item
        } catch(ValidationException e) {
            respond e.errors, model: [categoryList: categoryService.listByEnabled(true)], view: 'edit'
        }
    }
}
