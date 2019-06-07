<#import "parts/common.ftl" as c>
<@c.page>
    <div class = "mb-5">
        <h2>${rc.getMessage("message.registration")}</h2>
    </div>

    <#--<#if message?ifExists>-->
    <#if message??>
        <div class="alert alert-danger col-sm-4" role="alert">
            ${rc.getMessage("message.exist")}
        </div>
    </#if>
    <form action="/registration" method="post">
        <div class="form-group row">
            <label class ="col-sm-2" for="username">${rc.getMessage("message.login")}</label>
            <div class = "col-sm-5">
                <input type="text" class="form-control" name="username" placeholder="${rc.getMessage("message.enterlogin")}">
            </div>
        </div>
        <div class = "form-group row">
            <label class ="col-sm-2"  for="password">${rc.getMessage("message.password")}</label>
            <div class = "col-sm-5">
                <input type="password" class="form-control" name="password" placeholder="${rc.getMessage("message.password")}">
            </div>
        </div>
        <div class = "form-group row">
            <label class ="col-sm-2"  for="emal">${rc.getMessage("message.email")}</label>
            <div class = "col-sm-5">
                <input type="email" class="form-control" name="email" placeholder="${rc.getMessage("message.email")}">
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">${rc.getMessage("message.register")}</button>
    </form>
</@c.page>