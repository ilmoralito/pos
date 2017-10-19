<g:applyLayout name="column">
    <head>
        <title>Menu</title>
    </head>

    <content tag="main">
        <g:render template="tabs"/>

        <table class="table is-fullwidth">
            <colgroup>
                <col span="1" style="width: 95%;">
                <col span="1" style="width: 5%;">
            </colgroup>

            <tbody>
                <g:each in="${itemList}" var="item">
                    <tr>
                        <td>
                            <p class="is-size-3">${item.name}</p>
                            <span class="is-size-6">${item.description}</span>
                        </td>
                        <td class="is-size-3">${item.price}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </content>
</g:applyLayout>
