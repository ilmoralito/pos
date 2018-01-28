package ni.edu.uccleon.item

import grails.validation.ValidationException
import ni.edu.uccleon.CategoryService
import ni.edu.uccleon.ItemService
import ni.edu.uccleon.Category
import ni.edu.uccleon.Item

class ItemController {

    CategoryService categoryService
    ItemService itemService

    static allowedMethods = [ save: 'POST', update: 'PUT' ]

    def index() {
        respond itemService.list()
    }

    def show(final Long id) {
        respond id ? itemService.find(id) : null
    }

    def create() {
        respond new Item(params), model: [categoryList: makeItemModel().categoryList]
    }

    def save(SaveItemCommand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], model: [categoryList: makeItemModel().categoryList], view: 'create')

            return
        }

        try {
            Item item = itemService.save(command)

            flash.message = 'Articulo creado'
            redirect item
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [categoryList: makeItemModel().categoryList], view: 'create')
        }
    }

    def edit(final Long id) {
        Item item = id ? itemService.find(id) : null

        respond item, model: [categoryList: makeItemModel().categoryList]
    }

    def update(UpdateItemCommand command) {
        if (command.hasErrors()) {
            respond (
                [errors: command.errors],
                model: [
                    item: itemService.find(command.id),
                    categoryList: makeItemModel().categoryList
                ],view: 'edit')

            return
        }

        try {
            Item item = itemService.update(command)

            flash.message = 'Articulo actualizado'
            redirect item
        } catch(ValidationException e) {
            respond e.errors, model: [categoryList: makeItemModel().categoryList], view: 'edit'
        }
    }

    private ItemModel makeItemModel() {
        new ItemModel (categoryList: categoryService.listByEnabled(true))
    }
}

class ItemModel {
    List<Category> categoryList
}
