<g:applyLayout name="column">
    <head>
        <title>Menu</title>
    </head>

    <content tag="main">
        <g:render template="tabs" model="[categoryList: menu.categoryList]"/>

        <table class="table is-fullwidth is-hoverable">
            <colgroup>
                <col span="1" style="width: 95%;">
                <col span="1" style="width: 5%;">
            </colgroup>

            <tbody>
                <g:each in="${menu.itemList}" var="item">
                    <tr>
                        <td>
                            <p class="is-size-6">
                                <g:link
                                    controller="command"
                                    action="order"
                                    params="[table: params.table, itemName: item.name, itemCategory: item.category.name, itemUnitPrice: item.price]">
                                    ${item.name}
                                </g:link>
                            </p>
                            <span class="is-size-7">${item.description}</span>
                        </td>
                        <td class="is-size-6" style="vertical-align: middle;">
                            <g:formatNumber number="${item.price}" type="currency" currencyCode="NIO"/>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </content>
</g:applyLayout>
