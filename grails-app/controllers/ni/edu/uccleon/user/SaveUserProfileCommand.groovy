package ni.edu.uccleon.user

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class SaveUserProfileCommand implements Validateable {

    String username, fullName

    static constraints = {
        importFrom ni.edu.uccleon.User
    }
}
