databaseChangeLog = {
    include file: 'create-user-role-user_role-tables.groovy'
    include file: 'remove-verion-from-user-and-role.groovy'
    include file: 'change-table-names.groovy'
    include file: 'create-pos-tables-table.groovy'
    include file: 'prefix-all-tables-with-pos.groovy'
    include file: 'create-categories-and-items-tables.groovy'
}
