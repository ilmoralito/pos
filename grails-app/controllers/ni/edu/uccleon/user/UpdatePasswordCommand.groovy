package ni.edu.uccleon.user

import grails.plugin.springsecurity.SpringSecurityService
import ni.edu.uccleon.User

class UpdatePasswordCommand implements grails.validation.Validateable {

    @Autowired SpringSecurityService springSecurityService
    def passwordEncoder

    String currentPassword
    String newPassword
    String repeatNewPassword

    static constraints = {
        currentPassword validator: { String currentPassword, UpdatePasswordCommand obj ->
            String currentUserPassword = obj.springSecurityService.currentUser.password

            obj.passwordEncoder.isPasswordValid(currentUserPassword, currentPassword, null)
        }

        repeatNewPassword validator: { String repeatNewPassword, UpdatePasswordCommand obj ->
            repeatNewPassword == obj.newPassword
        }
    }

    User updatePassword() {
        User currentUser = springSecurityService.currentUser

        currentUser.password = newPassword

        currentUser.save(flush: true)
    }
}
