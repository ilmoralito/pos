<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="layout" content="auth"/>
        <title>Identificate</title>
    </head>
    <body>
        <form action="${postUrl ?: '/login/authenticate'}" method="POST" autocomplete="off">
            <div class="field">
                <label for="username" class="label">Nombre de usuario</label>
                <div class="control">
                    <input name="${usernameParameter ?: 'username'}" id="username" class="input" />
                </div>
            </div>

            <div class="field">
                <label for="password" class="label">Clave de paso</label>
                <div class="control">
                    <input type="password" name="${passwordParameter ?: 'password'}" id="password" class="input" />
                </div>
            </div>

            <div class="field">
                <div class="control">
                    <input type="submit" id="submit" value="${message(code: "springSecurity.login.button")}" class="button is-primary"/>
                </div>
            </div>
        </form>
    </body>
</html>
