<#include "security.ftl">
<#include "login.ftl">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">FTS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isActiveAccount>
                <li class="nav-item active">
                    <a class="nav-link" <#if isAdmin>href="/admin/admin" <#elseif isUser>href="/user/user"</#if>>Home<span class="sr-only">(current)</span></a>
                </li>
            </#if>
            <#if isUser>
                <li class="nav-item active">
                    <a class="nav-link" href="#">My Statistic<span class="sr-only">(current)</span></a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Users Statistic<span class="sr-only">(current)</span></a>
                </li>
            </#if>
        </ul>
    </div>
    <div class = "navbar-text mr-2">${name}</div>
    <#if isUser>
        <@logout />
    <#elseif isAdmin>
        <@logout/>
    </#if>

</nav>