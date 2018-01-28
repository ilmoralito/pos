databaseChangeLog = {

    changeSet(author: "sherlock (generated)", id: "1508971954220-1") {
        createTable(tableName: "pos_customers") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pos_customersPK")
            }

            column(name: "full_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "email", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "sherlock (generated)", id: "1508971954220-2") {
        createTable(tableName: "pos_order_details") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pos_order_detailsPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "item", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "unit_price", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "quantity", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "category", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "order_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "state", type: "VARCHAR(100)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1508971954220-3") {
        createTable(tableName: "pos_orders") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pos_ordersPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "table_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "waiter_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "total", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "customer_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(defaultValue: "pending", name: "state", type: "VARCHAR(100)") {
                constraints(nullable: "false")
            }

            column(name: "change", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1508971954220-4") {
        addUniqueConstraint(columnNames: "email", constraintName: "UC_POS_CUSTOMERSEMAIL_COL", tableName: "pos_customers")
    }

    changeSet(author: "sherlock (generated)", id: "1508971954220-5") {
        addForeignKeyConstraint(baseColumnNames: "customer_id", baseTableName: "pos_orders", constraintName: "FK1itjildvo7y2dnfdnca25tjyv", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_customers")
    }

    changeSet(author: "sherlock (generated)", id: "1508971954220-6") {
        addForeignKeyConstraint(baseColumnNames: "table_id", baseTableName: "pos_orders", constraintName: "FK26w4ioqx2hc1u2lnqnywhc0rh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_tables")
    }

    changeSet(author: "sherlock (generated)", id: "1508971954220-7") {
        addForeignKeyConstraint(baseColumnNames: "waiter_id", baseTableName: "pos_orders", constraintName: "FK3qm8nicogasdei3isbhtsfwl0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_users")
    }

    changeSet(author: "sherlock (generated)", id: "1508971954220-8") {
        addForeignKeyConstraint(baseColumnNames: "order_id", baseTableName: "pos_order_details", constraintName: "FKsyufemhpv6br530kqesqo0iyp", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_orders")
    }
}
