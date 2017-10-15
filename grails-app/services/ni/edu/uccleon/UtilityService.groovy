package ni.edu.uccleon

import org.hibernate.transform.AliasToEntityMapResultTransformer
import grails.gorm.transactions.Transactional
import org.hibernate.SessionFactory

@Transactional
class UtilityService {

    @Autowired
    SessionFactory sessionFactory

    List<Map<String, String>> roleSummary() {
        final session = sessionFactory.currentSession
        final String query = '''
            SELECT 
                r.authority,
                (SELECT 
                        COUNT(ur.role_id)
                    FROM
                        pos_users_roles ur
                            INNER JOIN
                        pos_users u ON ur.user_id = u.id
                    WHERE
                        ur.role_id = r.id AND u.enabled = TRUE) count
            FROM
                pos_roles r
            GROUP BY r.authority
        '''
        final sqlQuery = session.createSQLQuery(query)
        final results = sqlQuery.with {
            resultTransformer = AliasToEntityMapResultTransformer.INSTANCE

            list()
        }

        results
    }
}
