package ni.edu.uccleon.table

import grails.validation.ValidationException
import ni.edu.uccleon.TableService
import ni.edu.uccleon.Table

class TableController {

    @Autowired TableService tableService

    static allowedMethods = [ save: 'POST', update: 'PUT' ]

    def index() {
        respond tableService.list()
    }

    def show(final Long id) {
        respond id ? tableService.find(id) : null
    }

    def create() {
        respond new Table(params)
    }

    def save(final Integer number) {
        try {
            Table table = tableService.save(number)

            flash.message = 'Mesa agregada'
            redirect table
        } catch(ValidationException e) {
            respond ([errors: e.errors], view: 'create')
        }
    }

    def edit(final Long id) {
        respond id ? tableService.find(id) : null
    }

    def update(final Long id, final Integer number, final Boolean enabled) {
        try {
            Table table = tableService.update(id, number, enabled ?: false)

            flash.message = 'Mesa actualizada'
            redirect table
        } catch(ValidationException e) {
            respond e.errors, view: 'edit'
        }
    }
}
