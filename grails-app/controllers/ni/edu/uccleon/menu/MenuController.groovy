package ni.edu.uccleon.menu

import ni.edu.uccleon.CategoryService
import ni.edu.uccleon.ItemService
import ni.edu.uccleon.Item

class MenuController {

    @Autowired CategoryService categoryService
    @Autowired ItemService itemService

    def index(final String categoryName) {
        List<Category> categoryList = categoryService.listByEnabled(true)
        List<Item> itemList = itemService.listByCategoryName(categoryName ?: categoryList[0].name)

        [categoryList: categoryList, itemList: itemList]
    }
}
