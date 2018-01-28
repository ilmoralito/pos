package ni.edu.uccleon

import grails.gorm.services.Service
import ni.edu.uccleon.customer.SaveCustomerCommand
import ni.edu.uccleon.customer.UpdateCustomerCommand

interface ICustomerService {

    List<Customer> findAll()

    Customer find(final Serializable id)

    Customer delete(final Serializable id)

    Customer save(final SaveCustomerCommand command)

    Customer update(final UpdateCustomerCommand command)
}

@Service(Customer)
abstract class CustomerService implements ICustomerService {

    @Override
    Customer save(final SaveCustomerCommand command) {
        Customer customer = new Customer()

        customer.properties = command.properties

        customer.save(failOnError: true)
    }

    @Override
    Customer update(final UpdateCustomerCommand command) {
        Customer customer = find(command.id)

        if (customer) {
            customer.properties = command.properties
            customer.save(flush: true)
        }

        customer
    }
}
