package ni.edu.uccleon.user

class SaveUserComand implements grails.validation.Validateable {

    String username
    String fullName
    List<String> authorityList

    static constraints = {
        username nullable: false, blank: false
        fullName nullable: false, blank: false
        authorityList nullable: false, min: 1
    }
}