package ni.edu.uccleon

class Table {

    Integer number
    String state = 'free'
    Boolean enabled = true
    Date dateCreated
    Date lastUpdated

    static constraints = {
        number nullable: false, unique: true, min: 1
        state inList: ['free', 'busy'], maxSise: 100
    }

    static mapping = {
        table 'pos_tables'
        sort 'number'
        version false
        enabled defaultValue: true
        state defaultValue: "'free'"
    }
}
