<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="layout" content="main"/>
        <title><g:layoutTitle/></title>
        <g:layoutHead/>
    </head>
    <body>
        <div class="column">
            <g:render template="tabs"/>

            <g:pageProperty name="page.main"/>

            <g:if test="${flash?.message}">
                <div class="notification is-info">${flash.message}</div>
            </g:if>
        </div>
    </body>
</html>
