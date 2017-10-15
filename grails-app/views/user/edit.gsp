<g:applyLayout name="twoColumns">
    <head>
        <title>Editar usuario</title>
    </head>

    <content tag="main">
        <g:form resource="user" action="update" id="${user.id}" method="PUT" autocomplete="off">
            <g:hiddenField name="_method" value="PUT"/>
            <g:render template="form"/>

            <div class="field is-grouped">
                <div class="control">
                    <button type="submit" class="button is-primary">Actualizar</button>
                </div>

                <div class="control">
                    <g:link resource="${user}" class="button" method="GET">Regresar</g:link>
                </div>
            </div>

            <g:hasErrors bean="${errors}">
                <div>
                    <div class="notification is-info">
                        <g:renderErrors bean="${errors}"/>
                    </div>
                </div>
            </g:hasErrors>
        </g:form>
    </content>
</g:applyLayout>
