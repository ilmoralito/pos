package ni.edu.uccleon

class Item {

    String name
    Integer price
    Boolean enabled = true
    String description
    Date dateCreated
    Date lastUpdated

    static belongsTo = [category: Category]

    static constraints = {
        name nullable: false, blank: false, unique: true
        price nullable: false, min: 1
        description nullable: true
    }

    static mapping = {
        table 'pos_items'
        version false
        enabled defaultValue: true
        description type: 'text'
    }
}
