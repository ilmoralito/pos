package ni.edu.uccleon.table

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class UpdateTableCommand extends SaveTableCommand {

    Long id
    Boolean enabled
}
