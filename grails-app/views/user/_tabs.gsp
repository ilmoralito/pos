<div class="tabs is-centered">
    <ul>
        <li class="${actionName in ['profile', 'updateProfile'] ? 'is-active' : ''}">
            <g:link action="profile">Perfil</g:link>
        </li>
        <li class="${actionName in ['password', 'updatePassword'] ? 'is-active' : ''}">
            <g:link action="password">Clave</g:link>
        </li>
    </ul>
</div>
