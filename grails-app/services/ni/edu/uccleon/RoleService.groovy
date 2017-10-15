package ni.edu.uccleon

import grails.gorm.services.Service

@Service(Role)
interface RoleService {

    List<Role> list()
}
