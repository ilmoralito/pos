package ni.edu.uccleon

import grails.gorm.services.Service

@Service(Customer)
interface CustomerService {

    List<Customer> findAll()

    Customer find(final Serializable id)

    Customer delete(final Serializable id)

    Customer save(final String fullName, final String email)

    Customer update(final Serializable id, final String fullName, final String email)
}
