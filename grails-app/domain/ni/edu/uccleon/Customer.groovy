package ni.edu.uccleon

class Customer {

    String fullName
    String email

    static constraints = {
        fullName blank: false
        email nullable: true, email: true, unique: true
    }

    static mapping = {
        table 'pos_customers'
        sort 'fullName'
        version false
    }
}
