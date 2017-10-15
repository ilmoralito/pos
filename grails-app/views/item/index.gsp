<g:applyLayout name="twoColumns">
    <head>
        <title>Libreria de articulos</title>
    </head>

    <content tag="main">
        <g:if test="${itemList}">
            <div class="is-clearfix">
                <g:link resource="item" action="create" class="button is-primary is-pulled-right">Agregar</g:link>
            </div>

            <g:render template="/partials/categoriesItemsTabs"/>

            <table class="table is-bordered is-fullwidth">
                <colgroup>
                    <col span="1" style="width: 50%;">
                    <col span="1" style="width: 30%;">
                    <col span="1" style="width: 6%;">
                    <col span="1" style="width: 14%;">
                </colgroup>

                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Categoria</th>
                        <th>Precio</th>
                        <th>Estado</th>
                    </tr>
                </thead>

                <tbody>
                    <g:each in="${itemList}" var="item">
                        <tr>
                            <td>
                                <g:link resource="${item}" method="GET">${item.name}</g:link>
                            </td>
                            <td>${item.category.name}</td>
                            <td>
                                <g:formatNumber number="${item.price}" type="currency" currencyCode="NIO"/>
                            </td>
                            <td>
                                <pos:enabled enabled="${item.enabled}"/>
                            </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </g:if>
        <g:else>
            <div class="notification is-info">
                <g:render
                    template="/partials/noDataNotification"
                    model="[title: 'Articulos', subtitle: 'No hay articulos registradas', resource: 'item', action: 'Crear el primero']"/>
            </div>
        </g:else>
    </content>
</g:applyLayout>
