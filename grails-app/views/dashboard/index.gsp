<g:applyLayout name="twoColumns">
    <head>
        <title>Tablero</title>
    </head>

    <content tag="main">
        <g:render template="roleNotification" model="[roleSummary: roleSummary]"/>

        <g:render
            template="notification"
            model="[
                total: tableSummary.total,
                totalDisabled: tableSummary.totalDisabled,
                message: 'Mesas no habilitadas. Corregir para poder continuar',
                resource: 'table']"/>

        <g:render
            template="notification"
            model="[
                total: categorySummary.total,
                totalDisabled: categorySummary.totalDisabled,
                message: 'Categorias no habilitadas. Corregir para poder continuar',
                resource: 'category']"/>

        <g:render
            template="notification"
            model="[
                total: itemSummary.total,
                totalDisabled: itemSummary.totalDisabled,
                message: 'Articulos no habilitadas. Corregir para poder continuar',
                resource: 'item']"/>
    </content>
</g:applyLayout>
