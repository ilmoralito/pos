<g:applyLayout name="tables">
    <head>
        <title>Mesas</title>
    </head>

    <content tag="main">
        <table class="table is-hoverable is-fullwidth is-bordered">
            <colgroup>
                <col span="1" style="width: 5%;">
                <col span="1" style="width: 95%;">
            </colgroup>

            <tbody>
                <g:each in="${tableList}" var="table">
                    <tr>
                        <td>
                            <g:checkBox
                                form="form"
                                name="tableList"
                                value="${table.number}"
                                checked="${table.number in params.list('tables')*.toInteger()}"/>
                        </td>
                        <td>${table.number}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>

        <g:form name="form" resource="order" method="POST" autocomplete="off">
            <button class="button is-primary">Orden</button>
        </g:form>

        <g:hasErrors bean="${errors}">
            <div class="notification is-info">
                <ul>
                    <g:eachError bean="${errors}">
                        <li>${it}</li>
                    </g:eachError>
                </ul>
            </div>
        </g:hasErrors>
    </content>
</g:applyLayout>
