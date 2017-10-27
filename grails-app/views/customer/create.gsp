<g:applyLayout name="twoColumns">
    <head>
        <title>Crear cliente</title>
    </head>

    <content tag="main">
        <g:form resource="customer" action="save" method="POST" autocomplete="off">
            <g:render template="form"/>

            <div class="field">
                <div class="control">
                    <button type="submit" class="button is-primary">Agregar</button>
                </div>
            </div>
        </g:form>

        <g:render template="/partials/notification" model="[errors: errors]"/>
    </content>
</g:applyLayout>
