<div class="field">
    <label class="label" for="name">Nombre de categoria</label>
    <div class="control">
        <g:textField name="name" value="${category?.name}" class="input"/>
    </div>
</div>

<g:if test="${actionName in ['edit', 'update']}">
    <div class="field">
        <div class="control">
            <label class="checkbox">
                <g:checkBox name="enabled" value="${category?.enabled}"/> <pos:enabled enabled="${category.enabled}"/>
            </label>
        </div>
    </div>
</g:if>
