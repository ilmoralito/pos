<g:if test="${roleSummary.any { it.count == 0 }}">
    <div class="notification is-warning">
        Los roles <span class="has-text-weight-bold">${roleSummary.findAll { it.count == 0 }.authority.join(', ') }</span> son necesarios. Corregir para poder continuar 
        <a href="/secure/users" class="is-pulled-right">Corregir</a>
    </div>
</g:if>
