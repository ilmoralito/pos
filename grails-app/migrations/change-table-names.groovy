databaseChangeLog = {

    changeSet(author: "sherlock (generated)", id: "1507827856155-1") {
        createTable(tableName: "roles") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "rolesPK")
            }

            column(name: "authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-2") {
        createTable(tableName: "users") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "usersPK")
            }

            column(name: "password_expired", type: "BIT") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "BIT") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "BIT") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "BIT") {
                constraints(nullable: "false")
            }

            column(name: "full_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-3") {
        createTable(tableName: "users_roles") {
            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-4") {
        addPrimaryKey(columnNames: "user_id, role_id", constraintName: "users_rolesPK", tableName: "users_roles")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-5") {
        addUniqueConstraint(columnNames: "authority", constraintName: "UC_ROLESAUTHORITY_COL", tableName: "roles")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-6") {
        addUniqueConstraint(columnNames: "username", constraintName: "UC_USERSUSERNAME_COL", tableName: "users")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-7") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "users_roles", constraintName: "FK2o0jvgh89lemvvo17cbqvdxaa", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-8") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "users_roles", constraintName: "FKj6m8fwv7oqv74fcehir1a9ffy", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "roles")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-9") {
        dropForeignKeyConstraint(baseTableName: "user_role", constraintName: "FK859n2jvi8ivhui0rl0esws6o")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-10") {
        dropForeignKeyConstraint(baseTableName: "user_role", constraintName: "FKa68196081fvovjhkek5m97n3y")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-11") {
        dropUniqueConstraint(constraintName: "UC_ROLEAUTHORITY_COL", tableName: "role")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-12") {
        dropUniqueConstraint(constraintName: "UC_USERUSERNAME_COL", tableName: "user")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-13") {
        dropTable(tableName: "role")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-14") {
        dropTable(tableName: "user")
    }

    changeSet(author: "sherlock (generated)", id: "1507827856155-15") {
        dropTable(tableName: "user_role")
    }
}
