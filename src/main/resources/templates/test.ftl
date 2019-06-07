<#import "parts/common.ftl" as c>
<@c.page>
    <div class = "mb-2">
        <h2 class = "text-center">${rc.getMessage("message.testresult")}</h2>
    </div>
    <#list test?keys as key>
        <#if test[key]>
            <div class="alert alert-success w-25 p-3" role="alert">
                ${key}
            </div>
        <#else>
            <div class="alert alert-danger w-25 p-3" role="alert">
                ${key}
            </div>
        </#if>
    </#list>
    <div >
        <a href="/user/user" type="button" class="btn btn-primary btn-lg">Thanks</a>
    </div>
</@c.page>