<#import "parts/common.ftl" as c>
<#import  "parts/login.ftl" as l>
<@c.page>
    <h3>Login page</h3>
    <#if error>
        <div class="alert alert-danger col-sm-3" role="alert">
            Invalid password or username
        </div>
    </#if>
    <#if logout>
        <div class="alert alert-success col-sm-3" role="alert">
            You have been logged out
        </div>
    </#if>
    <div>
        <@l.login "/login"/>
        <a href = "/registration">Registration</a>
    </div>

</@c.page>