<g:applyLayout name="oneColumn">
    <head>
        <title>Actualizar clave</title>
    </head>

    <content tag="main">
        <g:form action="updatePassword" method="PUT" autocomplete="off">
            <g:hiddenField name="_method" value="PUT"/>

            <div class="field">
                <label for="currentPassword" class="label">Clave actual</label>
                <div class="control">
                    <g:passwordField name="currentPassword" class="input"/>
                </div>
            </div>

            <div class="field">
                <label for="newPassword" class="label">Nueva clave</label>
                <div class="control">
                    <g:passwordField name="newPassword" class="input"/>
                </div>
            </div>

            <div class="field">
                <label for="repeatNewPassword" class="label">Repetir nueva clave</label>
                <div class="control">
                    <g:passwordField name="repeatNewPassword" class="input"/>
                </div>
            </div>

            <div class="field">
                <g:submitButton name="send" value="Actualizar" class="button is-primary"/>
            </div>
        </g:form>

        <g:hasErrors bean="${errors}">
            <div class="notification is-info">
                <g:renderErrors bean="${errors}"/>
            </div>
        </g:hasErrors>
    </content>
</g:applyLayout>
