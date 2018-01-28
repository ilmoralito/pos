package ni.edu.uccleon.table

import grails.validation.ValidationException
import ni.edu.uccleon.TableService
import ni.edu.uccleon.Table

class TableController {

    TableService tableService

    static allowedMethods = [ save: 'POST', update: 'PUT' ]

    def index() {
        respond tableService.list()
    }

    def create() {
        respond new Table(params)
    }

    def show(final Long id) {
        respond id ? tableService.find(id) : null
    }

    def save(SaveTableCommand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], view: 'create')

            return
        }

        try {
            Table table = tableService.save(command)

            flash.message = 'Mesa agregada'
            redirect table
        } catch(ValidationException e) {
            respond ([errors: e.errors], view: 'create')
        }
    }

    def edit(final Long id) {
        respond id ? tableService.find(id) : null
    }

    def update(UpdateTableCommand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], model: [table: tableService.find(command.id)], view: 'edit')

            return
        }

        try {
            Table table = tableService.update(command)

            flash.message = 'Mesa actualizada'
            redirect table
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [table: e], view: 'edit')
        }
    }

    def list() {
        respond tableService.listByEnabled(true)
    }
}
