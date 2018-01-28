<div class="columns">
    <div class="column">
        <div class="field">
            <label class="label" for="fullName">Nombre completo</label>
            <div class="control">
                <g:textField name="fullName" value="${customer?.fullName}" class="input"/>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="field">
            <label class="label" for="email">Email</label>
            <div class="control">
                <g:field name="email" type="email" value="${customer?.email}" class="input"/>
            </div>
        </div>
    </div>
</div>
