package ni.edu.uccleon

class TableOrder extends Order {

    User waiter

    static constraints = {
        waiter nullable:false, blank: false
    }

    static hasMany = [orderTables: OrderTable]

    static mapping = {
        orderTables cascade: 'all-delete-orphan'
        table 'pos_table_orders'
        version false
    }
}
