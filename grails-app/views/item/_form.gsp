<div class="field">
    <label class="label" for="name">Nombre de articulo</label>
    <div class="control">
        <g:textField name="name" value="${item?.name}" class="input"/>
    </div>
</div>

<div class="field">
    <label class="label" for="price">Precio</label>
    <div class="control">
        <g:textField name="price" value="${item?.price}" class="input"/>
    </div>
</div>

<div class="field">
    <label class="label" for="description">Descripcion</label>
    <div class="control">
        <g:textArea name="description" value="${item?.description}" class="textarea"/>
    </div>
</div>

<div class="field">
    <label class="label" for="categoryId">Categoria</label>
    <div class="control">
        <div class="select">
            <g:select name="categoryId" from="${categoryList}" optionKey="id" optionValue="name" value="${item?.category?.id}"/>
        </div>
    </div>
</div>

<g:if test="${actionName in ['edit', 'update']}">
    <div class="field">
        <div class="control">
            <label class="checkbox">
                <g:checkBox name="enabled" value="${item?.enabled}"/> <pos:enabled enabled="${item.enabled}"/>
            </label>
        </div>
    </div>
</g:if>
