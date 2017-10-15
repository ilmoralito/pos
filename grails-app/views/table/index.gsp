<g:applyLayout name="twoColumns">
    <head>
        <title>Mesas</title>
    </head>

    <content tag="main">
        <g:if test="${tableList}">
            <div class="is-clearfix">
                <g:link resource="table" action="create" class="button is-primary is-pulled-right">Agregar</g:link>
            </div>

            <table class="table is-bordered is-fullwidth">
                <colgroup>
                    <col span="1" style="width: 86%;">
                    <col span="1" style="width: 14%;">
                </colgroup>

                <thead>
                    <tr>
                        <th>Numero</th>
                        <th>Estado</th>
                    </tr>
                </thead>

                <tbody>
                    <g:each in="${tableList}" var="table">
                        <tr>
                            <td>
                                <g:link resource="${table}" method="GET">${table.number}</g:link>
                            </td>
                            <td>
                                <pos:enabled enabled="${table.enabled}"/>
                            </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </g:if>
        <g:else>
            <g:render
                template="/partials/noDataNotification"
                model="[title: 'Mesas', subtitle: 'No hay mesas registradas', resource: 'table', action: 'Crear la primera']"/>
        </g:else>
    </content>
</g:applyLayout>
