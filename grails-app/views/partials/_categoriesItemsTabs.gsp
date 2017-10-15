<div class="tabs is-centered">
    <ul>
        <li class="${controllerName == 'category' ? 'is-active' : ''}">
            <g:link resource="category" action="index">Categorias</g:link>
        </li>
        <li class="${controllerName == 'item' ? 'is-active' : ''}">
            <g:link resource="item" action="index">Articulos</g:link>
        </li>
    </ul>
</div>
