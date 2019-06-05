<#macro login path>
    <form action="${path}" method="post">
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
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</#macro>

<#macro logout >
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">LogOut</button>
    </form>
</#macro>