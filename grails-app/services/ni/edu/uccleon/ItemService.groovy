package ni.edu.uccleon

import ni.edu.uccleon.item.UpdateItemCommand
import ni.edu.uccleon.item.SaveItemCommand
import ni.edu.uccleon.CategoryService
import grails.gorm.services.Service

interface IItemService {

    Number count()

    List<Item> list()

    Item find(final Serializable id)

    Number countByEnabled(final Boolean enabled)

    List<Item> listByCategoryName(final String categoryName)

    Item save(SaveItemCommand command)

    Item update(UpdateItemCommand command)
}

@Service(Item)
abstract class ItemService implements IItemService {

    CategoryService categoryService

    List<Item> listByCategoryName(final String categoryName) {
        Item.where { category.name == categoryName }.list()
    }

    Item save(SaveItemCommand command) {
        Category category = categoryService.find(command.categoryId)

        if (!category) {
            throw new IllegalArgumentException("Category $categoryId not found")
        }

        Item item = new Item()

        item.properties = command.properties

        category.addToItems(item)

        item.save(failOnError: true)
    }

    Item update(UpdateItemCommand command) {
        Category category = categoryService.find(command.categoryId)
        Item item = find(command.id)

        if (item && category) {
            item.properties = command.properties

            category.removeFromItems(item)
            category.addToItems(item)

            item.save(flush: true)
        }

        item
    }
}
