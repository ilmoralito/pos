<g:applyLayout name="oneSmallColumn">
    <head>
        <title>Perfil</title>
    </head>

    <content tag="main">
        <g:form action="updateProfile" method="PUT" autocomplete="off">
            <g:hiddenField name="_method" value="PUT"/>

            <div class="field">
                <label for="username" class="label">Nombre de usuario</label>
                <div class="control">
                    <g:textField name="username" value="${user.username}" class="input"/>
                </div>
            </div>

            <div class="field">
                <label for="fullName" class="label">Nombre completo</label>
                <div class="control">
                    <g:textField name="fullName" value="${user.fullName}" class="input"/>
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
