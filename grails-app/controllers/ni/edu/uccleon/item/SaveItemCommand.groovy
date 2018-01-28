package ni.edu.uccleon.item

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class SaveItemCommand implements Validateable {

    String name
    Integer price
    Boolean enabled = true
    String description
    Long categoryId

    static constraints = {
        importFrom ni.edu.uccleon.Item
    }
}
