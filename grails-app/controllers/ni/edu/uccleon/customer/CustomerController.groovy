package ni.edu.uccleon.customer

import grails.validation.ValidationException
import ni.edu.uccleon.CustomerService
import ni.edu.uccleon.Customer

class CustomerController {

    CustomerService customerService

    static allowedMethods = [ save: 'POST', update: 'PUT', delete: 'DELETE' ]

    def index() {
        respond customerService.findAll()
    }

    def show(final Long id) {
        respond id ? customerService.find(id) : null
    }

    def create() {
        respond new Customer(params)
    }

    def save(SaveCustomerCommand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], view: 'create')

            return
        }

        try {
            Customer customer = customerService.save(command)

            flash.message = 'Cliente creado'
            redirect customer
        } catch(ValidationException e) {
            respond ([errors: e.errors], view: 'create')
        }
    }

    def edit(final Long id) {
        respond id ? customerService.find(id) : null
    }

    def update(UpdateCustomerCommand command) {
        if (command.hasErrors()) {
            respond ([errors: command.errors], model: [customer: customerService.find(command.id)], view: 'edit')

            return
        }

        try {
            Customer customer = customerService.update(command)

            flash.message = 'Cliente actualizado'
            redirect customer
        } catch(ValidationException e) {
            respond ([errors: e.errors], model: [customer: customerService.find(id)], view: 'edit')
        }
    }

    def delete(final Long id) {
        Customer customer = customerService.delete(id)

        if (!customer) {
            notFound()

            return
        }

        flash.message = 'Cliente eliminado'
        redirect uri: '/secure/customers', method: 'GET'
    }

    private void notFound() {
        flash.message = 'Cliente no encontrado'
        redirect uri: '/secure/customers', method: 'GET'
    }
}
