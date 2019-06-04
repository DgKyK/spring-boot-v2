<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h2> Hello user !!!</h2>
    <div>
        <@l.logout/>
    </div>
    <div>
        <Strong>Choose theme : </Strong>
    </div>
    <div>
        <select>
            <#list tests as test>
                <option>
                <div>
                    <#--<b>${test.id}</b>
                    <span>${test.name}</span>-->
                    <i>${test.theme}</i>
                </div>
            <#else>
                <strong>NO TESTS</strong>
                </option>
            </#list>
        </select>
    </div>
    <div>
        <select>
            <#list tests as test>
                <option>
                <div>
                    <#--<b>${test.id}</b>
                    <span>${test.name}</span>-->
                    <i>${test.name}</i>
                </div>
            <#else>
                <strong>NO TESTS</strong>
                </option>
            </#list>
        </select>
    </div>

</@c.page>