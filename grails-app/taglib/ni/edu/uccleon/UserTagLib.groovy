package ni.edu.uccleon

class UserTagLib {
    static defaultEncodeAs = [taglib: 'html']
    static namespace = 'pos'

    def enabled = { attrs ->
        if(attrs?.enabled?.toBoolean()) {
            out << 'Habilitado'
        } else {
            out << 'No habilitado'
        }
    }
}
