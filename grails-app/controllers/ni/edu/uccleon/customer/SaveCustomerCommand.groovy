package ni.edu.uccleon.customer

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class SaveCustomerCommand implements Validateable {

    String fullName, email

    static constraints = {
        importFrom ni.edu.uccleon.Customer
    }
}
