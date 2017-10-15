package ni.edu.uccleon.dashboard

import ni.edu.uccleon.CategoryService
import ni.edu.uccleon.UtilityService
import ni.edu.uccleon.TableService

class DashboardController {

    @Autowired CategoryService categoryService
    @Autowired UtilityService utilityService
    @Autowired TableService tableService

    def index() {
        [
            roleSummary: utilityService.roleSummary(),
            categorySummary: createCategorySummary(),
            tableSummary: createTableSummary(),
            itemSummary: createItemSummary(),
        ]
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
            total: categoryService.count(),
            totalDisabled: categoryService.countByEnabled(false)
        )
    }
}

class Summary {
    Integer total
    Integer totalDisabled
}
