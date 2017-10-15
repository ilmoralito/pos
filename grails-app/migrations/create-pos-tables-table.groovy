databaseChangeLog = {

    changeSet(author: "sherlock (generated)", id: "1507840853653-1") {
        createTable(tableName: "pos_tables") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pos_tablesPK")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "number", type: "INT") {
                constraints(nullable: "false")
            }

            column(defaultValueBoolean: "true", name: "enabled", type: "BIT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1507840853653-2") {
        addUniqueConstraint(columnNames: "number", constraintName: "UC_POS_TABLESNUMBER_COL", tableName: "pos_tables")
    }
}
