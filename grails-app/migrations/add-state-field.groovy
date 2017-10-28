databaseChangeLog = {

    changeSet(author: "sherlock (generated)", id: "1508958836655-1") {
        addColumn(tableName: "pos_tables") {
            column(defaultValue: "free", name: "state", type: "varchar(100)") {
                constraints(nullable: "false")
            }
        }
    }
}
