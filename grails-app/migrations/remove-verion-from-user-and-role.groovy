databaseChangeLog = {

    changeSet(author: "sherlock (generated)", id: "1507827386254-1") {
        dropColumn(columnName: "version", tableName: "role")
    }

    changeSet(author: "sherlock (generated)", id: "1507827386254-2") {
        dropColumn(columnName: "version", tableName: "user")
    }
}
