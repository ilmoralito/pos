<div class="field">
    <label class="label" for="number">Numero</label>
    <div class="control">
        <g:field name="number" type="number" min="1" value="${table?.number}" class="input"/>
    </div>
</div>

<g:if test="${actionName in ['edit', 'update']}">
    <div class="field">
        <div class="control">
            <label class="checkbox">
                <g:checkBox name="enabled" value="${table?.enabled}"/> <pos:enabled enabled="${table.enabled}"/>
            </label>
        </div>
    </div>
</g:if>
