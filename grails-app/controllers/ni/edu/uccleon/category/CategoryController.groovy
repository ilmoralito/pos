package ni.edu.uccleon.category

import grails.validation.ValidationException
import ni.edu.uccleon.CategoryService
import ni.edu.uccleon.Category

class CategoryController {

    CategoryService categoryService

    static allowedMethods = [ save: 'POST', update: 'PUT' ]

    def index() {
        respond categoryService.list()
    }

    def show(final Long id) {
        respond id ? categoryService.find(id) : null
    }

    def create() {
        respond new Category(params)
    }

    def save(final String name) {
        try {
            Category category = categoryService.save(name)

            flash.message = 'Categoria agregada'
            redirect category
        } catch(ValidationException e) {
            respond ([errors: e.errors], view: 'create')
        }
    }

    def edit(final Long id) {
        respond id ? categoryService.find(id) : null
    }

    def update(final Long id, final String name, final Boolean enabled) {
        try {
            Category category = categoryService.update(id, name, enabled ?: false)

            flash.message = 'Categoria actualizada'
            redirect category
        } catch(ValidationException e) {
            respond e.errors, view: 'edit'
        }
    }
}
