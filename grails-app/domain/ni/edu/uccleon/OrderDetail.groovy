package ni.edu.uccleon

class OrderDetail {

    String item
    Integer quantity
    Integer unitPrice
    Date deliveryDateAndTime
    Date notificationDateAndTime

    Date dateCreated
    Date lastUpdated

    static constraints = {
        quantity min: 1
        unitPrice min: 1
        deliveryDateAndTime nullable: true
        notificationDateAndTime nullable: true
    }

    static belongsTo = [order: Order]

    static mapping = {
        table 'pos_order_details'
        verison false
    }
}
