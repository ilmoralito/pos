package ni.edu.uccleon

class OrderTable {

    Table table

    static constraints = {
        table nullable: false, blank: false
    }

    static belongsTo = [tableOrder: TableOrder]
}
