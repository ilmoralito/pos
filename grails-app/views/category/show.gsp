<g:applyLayout name="twoColumns">
    <head>
        <title>Categoria</title>
    </head>

    <content tag="main">
        <table class="table is-bordered is-fullwidth">
            <colgroup>
                <col span="1" style="width: 25%;">
                <col span="1" style="width: 75%;">
            </colgroup>

            <tbody>
                <tr>
                    <td>Nombre de usuario</td>
                    <td>${category.name}</td>
                </tr>

                <tr>
                    <td>Estado</td>
                    <td>
                        <pos:enabled enabled="${category.enabled}"/>
                    </td>
                </tr>
            </tbody>
        </table>

        <g:link resource="category" action="edit" id="${category.id}" method="GET" class="button is-primary">Editar</g:link>
    </content>
</g:applyLayout>
