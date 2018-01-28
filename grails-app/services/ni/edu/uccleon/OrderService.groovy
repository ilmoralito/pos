package ni.edu.uccleon

import grails.gorm.services.Service

@Service(Order)
interface OrderService {

    List<Order> findAll()

    Order save(final Order order)

    Order find(final Serializable id)

    Order delete(final Serializable id)

    // Order update(final Serializable id, final Order order)
}
