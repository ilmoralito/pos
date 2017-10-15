<g:applyLayout name="twoColumns">
    <head>
        <title>Editar mesas</title>
    </head>

    <content tag="main">
        <g:form resource="table" action="update" id="${table.id}" method="PUT" autocomplete="off">
            <g:hiddenField name="_method" value="PUT"/>
            <g:render template="form"/>

            <div class="field is-grouped">
                <div class="control">
                    <button type="submit" class="button is-primary">Actualizar</button>
                </div>

                <div class="control">
                    <g:link resource="${table}" method="GET" class="button">Regresar</g:link>
                </div>
            </div>
        </g:form>

        <g:render template="/partials/notification" model="[errors: table]"/>
    </content>
</g:applyLayout>
