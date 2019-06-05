<#import "parts/common.ftl" as c>
<@c.page>
<h2>Add new user</h2>
    ${message?ifExists}
    <form action="/registration" method="post">
        <div class="form-group row">
        <label class ="col-sm-2" for="username">Login</label>
        <div class = "col-sm-5">
            <input type="text" class="form-control" name="username" placeholder="Enter login">
        </div>
        </div>
        <div class = "form-group row">
            <label class ="col-sm-2"  for="password">Password</label>
            <div class = "col-sm-5">
                <input type="password" class="form-control" name="password" placeholder="Password">
            </div>
        </div>
        <div class = "form-group row">
            <label class ="col-sm-2"  for="emal">E-mail</label>
            <div class = "col-sm-5">
                <input type="email" class="form-control" name="email" placeholder="E-mail">
            </div>
        </div>
        <#--<div><label> User Login : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><label> E-mail: <input type="text" name="email"/> </label></div>-->
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Register</button>
    </form>
</@c.page>