<aside class="menu">
    <p class="menu-label">General</p>

    <ul class="menu-list">
        <li>
            <a href="/secure/dashboard" class="${controllerName == 'dashboard' ? 'is-active' : ''}">Dashboard</a>
        </li>
        <li>
            <g:link resource="user" action="index" class="${controllerName == 'user' ? 'is-active' : ''}">Empleados</g:link>
        </li>
    </ul>

    <p class="menu-label">Restaurante</p>

    <ul class="menu-list">
        <li>
            <g:link resource="table" action="index" class="${controllerName == 'table' ? 'is-active' : ''}">Mesas</g:link>
        </li>
        <li>
            <g:link resource="${controllerName == 'category' ? 'category' : 'item'}" action="index" class="${controllerName in ['category', 'item'] ? 'is-active' : ''}">Articulos</g:link>
        </li>
    </ul>

    <p class="menu-label">Clientes</p>

    <ul class="menu-list">
        <li>
            <g:link resource="customer" action="index" class="${controllerName == 'customer' ? 'is-active' : ''}">Lista de clientes</g:link>
        </li>
    </ul>
</aside>
