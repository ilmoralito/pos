package ni.edu.uccleon.dashboard

import ni.edu.uccleon.CategoryService
import ni.edu.uccleon.UtilityService
import ni.edu.uccleon.TableService
import ni.edu.uccleon.ItemService

class DashboardController {

    CategoryService categoryService
    UtilityService utilityService
    TableService tableService
    ItemService itemService

    def index() {
        respond ([:], model: [
            roleSummary: utilityService.roleSummary(),
            categorySummary: createCategorySummary(),
            tableSummary: createTableSummary(),
            itemSummary: createItemSummary(),
        ])
    }

    private Summary createTableSummary() {
        new Summary(
            total: tableService.count(),
            totalDisabled: tableService.countByEnabled(false)
        )
    }

    private Summary createCategorySummary() {
        new Summary(
            total: categoryService.count(),
            totalDisabled: categoryService.countByEnabled(false)
        )
    }

    private Summary createItemSummary() {
        new Summary(
            total: itemService.count(),
            totalDisabled: itemService.countByEnabled(false)
        )
    }
}

class Summary {
    Integer total
    Integer totalDisabled
}
