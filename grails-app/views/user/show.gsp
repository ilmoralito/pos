<g:applyLayout name="twoColumns">
    <head>
        <title>Usuario</title>
    </head>

    <content tag="main">
        <table class="table is-bordered is-fullwidth">
            <col width="25%;">
            <col width="75%;">

            <tbody>
                <tr>
                    <td>Nombre de usuario</td>
                    <td>${user.username}</td>
                </tr>

                <tr>
                    <td>Nombre completo</td>
                    <td>${user.fullName}</td>
                </tr>

                <tr>
                    <td>Estado</td>
                    <td>
                        <pos:enabled enabled="${user.enabled}"/>
                    </td>
                </tr>

                <tr>
                    <td>Roles</td>
                    <td>
                        <g:join in="${userRoleList.authority}"/>
                    </td>
                </tr>
            </tbody>
        </table>

        <g:link
            resource="user"
            action="edit"
            id="${user.id}"
            method="GET"
            class="button is-primary">Editar</g:link>

        <a
            href="#"
            class="button
            is-danger"
            onclick="if (confirm('¿Seguro?')) document.querySelector('#resetForm').submit()">
            Restablecer clave</a>

        <g:form
            name="resetForm"
            resource="user"
            action="restorePassword"
            id="${user.id}"
            method="PUT">
            <g:hiddenField name="_method" value="PUT"/>
        </g:form>
    </content>
</g:applyLayout>
