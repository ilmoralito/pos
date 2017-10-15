package ni.edu.uccleon.user

class UpdateUserComand implements grails.validation.Validateable {

    Long id
    String username
    String fullName
    Boolean enabled
    List<String> authorityList

    static constraints = {
        username nullable: false, blank: false
        fullName nullable: false, blank: false
        authorityList nullable: false, min: 1
    }
}