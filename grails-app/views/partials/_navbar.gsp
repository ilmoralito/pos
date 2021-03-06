<nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="container">
        <div class="navbar-brand">
            <a href="#" class="navbar-item is-size-4">SAYULAPA</a>

            <button class="button navbar-burger">
                <span></span>
                <span></span>
                <span></span>
            </button>
        </div>

        <div class="navbar-menu">
            <div class="navbar-end">
                <sec:ifAnyGranted roles="ROLE_WAITER">
                    <g:link
                        resource="table"
                        action="list"
                        class="navbar-item ${controllerName == 'table' ? 'is-active' : ''}"
                        method="GET">
                        Mesas
                    </g:link>
                </sec:ifAnyGranted>

                <div class="navbar-item has-dropdown" onclick="this.classList.toggle('is-active')">
                    <a href="#" class="navbar-link ${controllerName == 'user' ? 'is-active' : ''}">
                        <sec:loggedInUserInfo field='username'/>
                    </a>

                    <div class="navbar-dropdown">
                        <g:link
                            controller="user"
                            action="profile"
                            class="navbar-item ${controllerName == 'user' && actionName in ['profile', 'updateProfile', 'password', 'updatePassword'] ? 'is-active' : ''}">Perfil</g:link>

                        <sec:ifAnyGranted roles="ROLE_WAITER">
                            <g:link
                                controller="menu"
                                action="index"
                                class="navbar-item ${controllerName == 'menu' ? 'is-active' : ''}">
                                Menu
                            </g:link>
                        </sec:ifAnyGranted>

                        <g:if test="${actionName in ['profile', 'password', 'updatePassword']}">
                            <sec:ifAnyGranted roles="ROLE_MANAGER, ROLE_ADMINISTRATOR">
                                <g:link
                                    controller="dashboard"
                                    class="navbar-item ${controllerName == 'dashboard' ? 'is-active' : ''}">Board</g:link>
                            </sec:ifAnyGranted>
                        </g:if>

                        <hr class="navbar-divider">
                        <a href="#" class="navbar-item" onclick="document.querySelector('#logout').submit()">Salir</a>
                        <g:form name="logout" controller="logout">
                            <g:hiddenField name="_method" value="POST"/>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
