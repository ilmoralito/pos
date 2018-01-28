package ni.edu.uccleon

import grails.gorm.services.Service
import ni.edu.uccleon.table.SaveTableCommand
import ni.edu.uccleon.table.UpdateTableCommand

interface ITableService {

    Number count()

    List<Table> list()

    Table find(final Serializable id)

    Table save(final SaveTableCommand command)

    Table update(final UpdateTableCommand command)

    Number countByEnabled(final Boolean enabled)

    List<Table> listByEnabled(final Boolean enabled)
}

@Service(Table)
abstract class TableService implements ITableService {

    @Override
    Table save(final SaveTableCommand command) {
        Table table = new Table()

        table.properties = command.properties

        table.save(failOnError: true)
    }

    @Override
    Table update(final UpdateTableCommand command) {
        Table table = find(command.id)

        if (table) {
            table.properties = command.properties
            table.save(flush: true)
        }

        table
    }
}
