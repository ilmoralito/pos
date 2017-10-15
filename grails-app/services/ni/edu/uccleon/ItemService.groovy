package ni.edu.uccleon

import ni.edu.uccleon.CategoryService
import grails.gorm.services.Service

interface IItemService {

    Number count()

    List<Item> list()

    Item find(final Serializable id)

    Number countByEnabled(final Boolean enabled)

    Item save(final String name, final Integer price, final String description, final Serializable categoryId)

    Item update(final Serializable id, final String name, final Integer price, final Boolean enabled, final String description, final Serializable categoryId)
}

@Service(Item)
abstract class ItemService implements IItemService {

    @Autowired CategoryService categoryService

    Item save(final String name, final Integer price, final String description, final Serializable categoryId) {
        Category category = categoryService.find(categoryId)

        if (!category) {
            throw new IllegalArgumentException("Category $categoryId not found")
        }

        Item item = new Item(
            name: name,
            price: price,
            description: description
        )

        category.addToItems(item)

        item.save(failOnError: true)
    }

    Item update(final Serializable id, final String name, final Integer price, final Boolean enabled, final String description, final Serializable categoryId) {
        Category category = categoryService.find(categoryId)
        Item item = find(id)

        if (item && category) {
            item.name = name
            item.price = price
            item.enabled = enabled
            item.description = description
            item.category = category

            item.save(failOnError: true, flush: true)
        }

        item
    }
}
