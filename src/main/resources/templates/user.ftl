<#import "parts/common.ftl" as c>
    <#include "parts/security.ftl">
<@c.page>
    <div>
        <h2> Hello ${name} !!!</h2>
    </div>
    <div >
        <Strong>Choose the Test from catalog : </Strong>
    </div>
    <form action="/user/test" method="post" name="test">
    <div>
        <select class="custom-select col-sm-5 mt-2" name="chosenTest">
            <#list tests as test>
                <option>
                <div>
                    <b>${test.id}</b>
                    <strong>|</strong>
                    <span>${test.name}</span>
                    <strong>|</strong>
                    <i>${test.theme}</i>
                </div>
            <#else>
                <strong>NO TESTS</strong>
                </option>
            </#list>
        </select>
    </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Pass Test</button>
    </form>
</@c.page>