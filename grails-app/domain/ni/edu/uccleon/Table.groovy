package ni.edu.uccleon

class Table {

    Integer number
    Boolean enabled = true
    Date dateCreated
    Date lastUpdated

    static constraints = {
        number nullable: false, unique: true, min: 1
    }

    static mapping = {
        table 'pos_tables'
        sort 'number'
        version false
        enabled defaultValue: true
    }
}
