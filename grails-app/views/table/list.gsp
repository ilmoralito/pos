<g:applyLayout name="column">
    <head>
        <title>Mesas</title>
    </head>

    <content tag="main">
        <ul class="tables">
            <g:each in="${tableList.collate(4)}" var="set">
                <ul>
                    <g:each in="${set}" var="table">
                        <li class="${table.state == 'busy' ? 'busy' : ''}">
                            <g:if test="${table.state == 'free'}">
                                <g:link controller="command" action="create" params="[table: table.number]" class="is-size-3">
                                    ${table.number}
                                </g:link>
                            </g:if>
                            <g:else>
                                <g:link controller="command" action="menu" params="[table: table.number]" class="is-size-3">
                                    ${table.number}
                                </g:link>
                            </g:else>
                        </li>
                    </g:each>
                </ul>
            </g:each>
        </ul>
    </content>
</g:applyLayout>
