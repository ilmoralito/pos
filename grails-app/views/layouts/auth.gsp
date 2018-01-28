<!doctype html>
<html lang="en" class="no-js">
    <head>
        <title><g:layoutTitle default="POS"/></title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <asset:stylesheet src="application.css"/>
        <g:layoutHead/>
    </head>
    <body>
        <div class="hero is-medium intro">
            <div class="hero-body">
                <div class="container">
                    <div class="columns">
                        <div class="column is-4"></div>
                        <div class="column">
                            <div class="box">
                                <h1 class="is-size-3 has-text-centered">Identificate</h1>

                                <g:layoutBody/>

                                <g:if test="${flash?.message}">
                                    <br>
                                    <div class="notification is-info">${flash.message}</div>
                                </g:if>
                            </div>
                        </div>
                        <div class="column is-4"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
