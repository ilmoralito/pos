<g:applyLayout name="twoColumns">
    <head>
        <title>Cliente</title>
    </head>

    <content tag="main">
        <g:if test="${customerList}">
            <div class="is-clearfix">
                <g:link resource="customer" action="create" class="button is-primary is-pulled-right">Agregar</g:link>
            </div>

            <table class="table is-bordered is-fullwidth">
                <colgroup>
                    <col span="1" style="width: 60%;">
                    <col span="1" style="width: 40%;">
                </colgroup>

                <thead>
                    <tr>
                        <th>Nombre completo</th>
                        <th>Email</th>
                    </tr>
                </thead>

                <tbody>
                    <g:each in="${customerList}" var="customer">
                        <tr>
                            <td>
                                <g:link resource="${customer}" method="GET">${customer.fullName}</g:link>
                            </td>
                            <td>${customer.email}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </g:if>
        <g:else>
            <g:render
                template="/partials/noDataNotification"
                model="[title: 'Lista de clientes', subtitle: 'No hay clientes registrados', resource: 'customer', action: 'Crear el primero']"/>
        </g:else>
    </content>
</g:applyLayout>
