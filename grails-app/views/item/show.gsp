<g:applyLayout name="twoColumns">
    <head>
        <title>Articulo</title>
    </head>

    <content tag="main">
        <table class="table is-bordered is-fullwidth">
            <col width="25%">
            <col width="75%">

            <tbody>
                <tr>
                    <td>Nombre</td>
                    <td>${item.name}</td>
                </tr>

                <tr>
                    <td>Precio</td>
                    <td>
                        <g:formatNumber number="${item.price}" type="currency" currencyCode="NIO"/>
                    </td>
                </tr>

                <tr>
                    <td>Descripcion</td>
                    <td>${item.description}</td>
                </tr>

                <tr>
                    <td>Categoria</td>
                    <td>${item.category.name}</td>
                </tr>

                <tr>
                    <td>Estado</td>
                    <td>
                        <pos:enabled enabled="${item.enabled}"/>
                    </td>
                </tr>
            </tbody>
        </table>

        <g:link resource="item" action="edit" id="${item.id}" method="GET" class="button is-primary">Editar</g:link>
    </content>
</g:applyLayout>
