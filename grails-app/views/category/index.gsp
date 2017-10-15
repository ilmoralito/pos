<g:applyLayout name="twoColumns">
    <head>
        <title>Categorias</title>
    </head>

    <content tag="main">
        <g:if test="${categoryList}">
            <div class="is-clearfix">
                <g:link resource="category" action="create" class="button is-primary is-pulled-right">Agregar</g:link>
            </div>

            <g:render template="/partials/categoriesItemsTabs"/>

            <table class="table is-bordered is-fullwidth">
                <colgroup>
                    <col span="1" style="width: 86%;">
                    <col span="1" style="width: 14%;">
                </colgroup>

                <thead>
                    <tr>
                        <th>Categorias</th>
                        <th>Estado</th>
                    </tr>
                </thead>

                <tbody>
                    <g:each in="${categoryList}" var="category">
                        <tr>
                            <td>
                                <g:link resource="${category}" method="GET">${category.name}</g:link>
                            </td>
                            <td>
                                <pos:enabled enabled="${category.enabled}"/>
                            </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </g:if>
        <g:else>
            <g:render
                template="/partials/noDataNotification"
                model="[title: 'Categorias', subtitle: 'No hay categorias registradas', resource: 'category', action: 'Crear el primero']"/>
        </g:else>
    </content>
</g:applyLayout>
