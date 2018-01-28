package ni.edu.uccleon.user

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class UpdateUserComand extends SaveUserComand implements grails.validation.Validateable {

    Long id
    Boolean enabled
}
