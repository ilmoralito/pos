package ni.edu.uccleon

import grails.plugin.springsecurity.SpringSecurityService
import grails.gorm.services.Service
import ni.edu.uccleon.TableService

interface ITableOrderService {

    TableOrder save(final User waiter, final List<Integer> tableList)
}

@Service(TableOrder)
abstract class TableOrderService implements ITableOrderService {

    SpringSecurityService springSecurityService
    TableService tableService

    @Override
    TableOrder save(final User waiter, final List<Integer> tableList) {
        TableOrder tableOrder = new TableOrder(waiter: waiter)

        tableList.each { tableId ->
            Table table = tableService.find(tableId)

            tableOrder.addToOrderTables(table: table)
        }

        tableOrder.save(failOnError: true, flush: true)
    }
}
