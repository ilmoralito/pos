package ni.edu.uccleon.customer

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class UpdateCustomerCommand extends SaveCustomerCommand implements Validateable {

    Long id
}
