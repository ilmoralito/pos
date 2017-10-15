<g:applyLayout name="twoColumns">
    <head>
        <title>Crear articulo</title>
    </head>

    <content tag="main">
        <g:if test="${!categoryList}">
            <div class="notification is-warning">
                Categorias son requeridas para poder continuar <a href="/secure/categories/create" class="is-pulled-right">Corregir</a>
            </div>
        </g:if>
        <g:else>
            <g:form resource="item" action="save" method="POST" autocomplete="off">
                <g:render template="form"/>

                <div class="field">
                    <div class="control">
                        <button type="submit" class="button is-primary">Confirmar</button>
                    </div>
                </div>
            </g:form>
        </g:else>

        <g:render template="/partials/notification" model="[errors: errors]"/>
    </content>
</g:applyLayout>
