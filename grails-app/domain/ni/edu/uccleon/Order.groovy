package ni.edu.uccleon

class Order {

    User cashier
    Integer total
    Integer change
    Customer customer
    Date paymentDateAndTime
    String status = 'open'

    Date dateCreated
    Date lastUpdated

    static constraints = {
        cashier nullable: true
        total nullable: true
        change nullable: true
        customer nullable: true
        paymentDateAndTime nullable: true
        status inList: ['open', 'pending', 'closed']
    }

    static hasMany = [orderDetails: OrderDetail]

    static mapping = {
        orderDetails cascade: 'all-delete-orphan'
        status column: 'status', type: 'varchar(100)', defaultValue: 'open'
        table 'pos_orders'
        verison false
    }
}
