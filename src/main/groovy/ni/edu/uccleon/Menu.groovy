package ni.edu.uccleon

import org.springframework.beans.factory.annotation.Autowired

class Menu {

    @Autowired
    CategoryService categoryService

    @Autowired
    ItemService itemService

    List<Category> categoryList
    List<Item> itemList

    public final Menu create(final String categoryName) {
        List<Category> categoryList = categoryService.listByEnabled(true)

        new Menu (
            categoryList: categoryList,
            itemList: itemService.listByCategoryName(categoryName ?: categoryList[0].name)
        )
    }
}
