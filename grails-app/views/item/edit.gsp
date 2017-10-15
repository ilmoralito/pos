<g:applyLayout name="twoColumns">
    <head>
        <title>Crear articulo</title>
    </head>

    <content tag="main">
        <g:form resource="item" action="update" id="${item.id}" method="PUT" autocomplete="off">
            <g:hiddenField name="_method" value="PUT"/>
            <g:render template="form"/>

            <div class="field is-grouped">
                <div class="control">
                    <button type="submit" class="button is-primary">Actualizar</button>
                </div>

                <div class="control">
                    <g:link resource="${item}" method="GET" class="button">Regresar</g:link>
                </div>
            </div>
        </g:form>

        <g:render template="/partials/notification" model="[errors: item.errors]"/>
    </content>
</g:applyLayout>