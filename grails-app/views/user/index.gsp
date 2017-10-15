<g:applyLayout name="twoColumns">
    <head>
        <title>Usuarios</title>
    </head>

    <content tag="main">
        <div class="is-clearfix">
            <g:link resource="user" action="create" class="button is-primary is-pulled-right">Agregar</g:link>
        </div>

        <table class="table is-bordered is-fullwidth">
            <colgroup>
                <col span="1" style="width: 86%;">
                <col span="1" style="width: 14%;">
            </colgroup>

            <thead>
                <tr>
                    <th>Lista de usuarios</th>
                    <th>Estado</th>
                </tr>
            </thead>

            <tbody>
                <g:each in="${userList}" var="user">
                    <tr>
                        <td>
                            <g:link resource="${user}" method="GET">${user.fullName}</g:link>
                        </td>
                        <td>
                            <pos:enabled enabled="${user.enabled}"/>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </content>
</g:applyLayout>
