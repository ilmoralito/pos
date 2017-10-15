databaseChangeLog = {

    changeSet(author: "sherlock (generated)", id: "1507841451928-1") {
        createTable(tableName: "pos_roles") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pos_rolesPK")
            }

            column(name: "authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-2") {
        createTable(tableName: "pos_users") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pos_usersPK")
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

    changeSet(author: "sherlock (generated)", id: "1507841451928-3") {
        createTable(tableName: "pos_users_roles") {
            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-4") {
        addPrimaryKey(columnNames: "user_id, role_id", constraintName: "pos_users_rolesPK", tableName: "pos_users_roles")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-5") {
        addUniqueConstraint(columnNames: "authority", constraintName: "UC_POS_ROLESAUTHORITY_COL", tableName: "pos_roles")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-6") {
        addUniqueConstraint(columnNames: "username", constraintName: "UC_POS_USERSUSERNAME_COL", tableName: "pos_users")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-7") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "pos_users_roles", constraintName: "FK1jivlhslyrfpvgciy2ybj67h7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_users")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-8") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "pos_users_roles", constraintName: "FKeiskrkt0hi5jfmih6ukcmd0js", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_roles")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-9") {
        dropForeignKeyConstraint(baseTableName: "users_roles", constraintName: "FK2o0jvgh89lemvvo17cbqvdxaa")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-10") {
        dropForeignKeyConstraint(baseTableName: "users_roles", constraintName: "FKj6m8fwv7oqv74fcehir1a9ffy")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-11") {
        dropUniqueConstraint(constraintName: "UC_ROLESAUTHORITY_COL", tableName: "roles")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-12") {
        dropUniqueConstraint(constraintName: "UC_USERSUSERNAME_COL", tableName: "users")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-13") {
        dropTable(tableName: "roles")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-14") {
        dropTable(tableName: "users")
    }

    changeSet(author: "sherlock (generated)", id: "1507841451928-15") {
        dropTable(tableName: "users_roles")
    }
}
