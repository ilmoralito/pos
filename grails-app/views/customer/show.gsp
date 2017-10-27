<g:applyLayout name="twoColumns">
    <head>
        <title>Cliente</title>
    </head>

    <content tag="main">
        <table class="table is-bordered is-fullwidth">
            <colgroup>
                <col span="1" style="width: 25%;">
                <col span="1" style="width: 75%;">
            </colgroup>

            <tbody>
                <tr>
                    <td>Nombre completo</td>
                    <td>${customer.fullName}</td>
                </tr>

                <tr>
                    <td>Email</td>
                    <td>${customer.email}</td>
                </tr>
            </tbody>
        </table>

        <g:link resource="customer" action="edit" id="${customer.id}" method="GET" class="button is-primary">Editar</g:link>
        <a class="button is-danger" onclick="if (confirm('¿Seguro?')) document.querySelector('#form').submit()">Eliminar</a>

        <g:form name="form" resource="customer" action="delete" id="${customer.id}" method="DELETE">
            <g:hiddenField name="_method" value="DELETE"/>
        </g:form>
    </content>
</g:applyLayout>
