package ni.edu.uccleon

import grails.gorm.services.Service

@Service(Category)
interface CategoryService {

    Number count()

    List<Category> list()

    Category save(final String name)

    Category find(final Serializable id)

    Number countByEnabled(final Boolean enabled)

    List<Category> listByEnabled(final Boolean enabled)

    Category update(final Serializable id, final String name, final Boolean enabled)
}
