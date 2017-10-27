package ni.edu.uccleon.customer

import grails.validation.ValidationException
import ni.edu.uccleon.CustomerService
import ni.edu.uccleon.Customer

class CustomerController {

    @Autowired CustomerService customerService

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

    def save(final String fullName, final String email) {
        try {
            Customer customer = customerService.save(fullName, email)

            flash.message = 'Cliente creado'
            redirect customer
        } catch(ValidationException e) {
            respond ([errors: e.errors], view: 'create')
        }
    }

    def edit(final Long id) {
        respond id ? customerService.find(id) : null
    }

    def update(final Long id, final String fullName, final String email) {
        try {
            Customer customer = customerService.update(id, fullName, email)

            flash.message = 'Datos de cliente actualizado'
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
