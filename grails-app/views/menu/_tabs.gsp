<div class="tabs is-centered">
    <ul>
        <g:each in="${categoryList}" var="category" status="index">
            <li class="${(!params.categoryName && index == 0) || (params.categoryName == category.name) ? 'is-active' : ''}">
                <g:link controller="menu" action="index" params="[categoryName: category.name]">${category.name}</g:link>
            </li>
        </g:each>
    </ul>
</div>
