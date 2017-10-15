package ni.edu.uccleon

class Category {

    String name
    Boolean enabled = true
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name nullable: false, blank: false, unique: true
    }

    static hasMany = [items: Item]

    static mapping = {
        table 'pos_categories'
        version false
        enabled defaultValue: true
        items cascade: 'all-delete-orphan'
    }
}
