<g:applyLayout name="column">
    <head>
        <title>Mesas</title>
    </head>

    <content tag="main">
        <g:form resource="order" action="save" method="POST">
            <div class="field">
                <label class="label">Selecciona o crea un nuevo cliente</label>
                <div class="control">
                    <g:textField name="fullName" class="input" list="customerList" placeholder="Filtrar"/>
                    <datalist id="customerList">
                        <g:each in="${customerList}" var="customer">
                            <option>${customer.fullName}</option>
                        </g:each>
                    </datalist>
                </div>
            </div>

            <div class="field">
                <div class="control">
                    <button type="submit" class="button is-primary">Confirmar</button>
                </div>
            </div>
        </g:form>
    </content>
</g:applyLayout>
