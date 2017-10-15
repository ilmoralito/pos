<g:applyLayout name="twoColumns">
    <head>
        <title>Crear usuario</title>
    </head>

    <content tag="main">
        <g:form resource="user" action="save" method="POST" autocomplete="off">
            <g:render template="form"/>

            <div class="field">
                <div class="control">
                    <button type="submit" class="button is-primary">Confirmar</button>
                </div>
            </div>

            <g:hasErrors bean="${errors}">
                <div class="notification is-info">
                    <g:renderErrors bean="${errors}"/>
                </div>
            </g:hasErrors>
        </g:form>
    </content>
</g:applyLayout>
