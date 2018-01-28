package ni.edu.uccleon.user

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import ni.edu.uccleon.Role

@GrailsCompileStatic
class SaveUserComand extends SaveUserProfileCommand implements Validateable {

    List<Role> roles

    static constraints = {
        roles nullable: false, min: 1
    }
}
