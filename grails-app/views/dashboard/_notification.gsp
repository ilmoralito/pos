<g:if test="${!total || total == totalDisabled}">
    <div class="notification is-warning">
        <span class="has-text-weight-bold">${message}</span> <g:link resource="${resource}" action="index" class="is-pulled-right">Corregir</g:link>
    </div>
</g:if>
