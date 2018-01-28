package ni.edu.uccleon.item

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class UpdateItemCommand extends SaveItemCommand implements Validateable {

    Long id
}
