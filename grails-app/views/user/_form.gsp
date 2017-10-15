<div class="field">
    <label class="label" for="username">Nombre de usuario</label>
    <div class="control">
        <g:textField name="username" value="${user?.username}" class="input"/>
    </div>
</div>

<div class="field">
    <label class="label" for="fullName">Nombre completo</label>
    <div class="control">
        <g:textField name="fullName" value="${user?.fullName}" class="input"/>
    </div>
</div>

<g:if test="${actionName in ['edit', 'update']}">
    <div class="field">
        <div class="control">
            <label class="checkbox">
                <g:checkBox name="enabled" value="${user?.enabled}"/> <pos:enabled enabled="${user.enabled}"/>
            </label>
        </div>
    </div>
</g:if>

<div class="field">
    <label class="label">Roles</label>
    <g:each in="${roleList}" var="role">
        <div class="field">
            <div class="control">
                <label class="checkbox">
                    <g:checkBox name="authorityList" value="${role.authority}" checked="${role in userRoleList}"/> ${role.authority}
                </label>
            </div>
        </div>
    </g:each>
</div>
