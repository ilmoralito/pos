package ni.edu.uccleon.table

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class SaveTableCommand implements grails.validation.Validateable {

    Integer number

    static constraints = {
        importFrom ni.edu.uccleon.Table
    }
}
