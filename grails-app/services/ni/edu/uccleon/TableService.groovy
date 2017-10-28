package ni.edu.uccleon

import grails.gorm.services.Service

@Service(Table)
interface TableService {

    Number count()

    List<Table> list()

    Table save(final Integer number)

    Table find(final Serializable id)

    Number countByEnabled(final Boolean enabled)

    List<Table> listByEnabled(final Boolean enabled)

    Table update(final Serializable id, final Integer number, final Boolean enabled)
}
