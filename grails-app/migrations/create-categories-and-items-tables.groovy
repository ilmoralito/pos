databaseChangeLog = {

    changeSet(author: "sherlock (generated)", id: "1507913715876-1") {
        createTable(tableName: "pos_categories") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pos_categoriesPK")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(defaultValueBoolean: "true", name: "enabled", type: "BIT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1507913715876-2") {
        createTable(tableName: "pos_items") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pos_itemsPK")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "price", type: "DOUBLE") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "category_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(defaultValueBoolean: "true", name: "enabled", type: "BIT") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "LONGTEXT")
        }
    }

    changeSet(author: "sherlock (generated)", id: "1507913715876-3") {
        addUniqueConstraint(columnNames: "name", constraintName: "UC_POS_CATEGORIESNAME_COL", tableName: "pos_categories")
    }

    changeSet(author: "sherlock (generated)", id: "1507913715876-4") {
        addUniqueConstraint(columnNames: "name", constraintName: "UC_POS_ITEMSNAME_COL", tableName: "pos_items")
    }

    changeSet(author: "sherlock (generated)", id: "1507913715876-5") {
        addForeignKeyConstraint(baseColumnNames: "category_id", baseTableName: "pos_items", constraintName: "FKsfcjd568t4i6m9qnhhskacv0b", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_categories")
    }
}
