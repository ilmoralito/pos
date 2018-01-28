package ni.edu.uccleon.order

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class SaveTableOrderCommand implements grails.validation.Validateable {

    List<Integer> tableList

    static constraints = {
        tableList nullable: false
    }
}
