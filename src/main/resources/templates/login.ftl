<#import "parts/common.ftl" as c>
<#import  "parts/login.ftl" as l>
<@c.page>
Login page
    <div>
    <#if error>
        Invalid password or username
    </#if>
    </div>
    <div>
        <#if logout>
            You have been logged out
        </#if>
    </div>
<@l.login "/login"/>
<a href = "/registration">Registration</a>
</@c.page>