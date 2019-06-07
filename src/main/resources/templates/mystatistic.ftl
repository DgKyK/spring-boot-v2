<#import "parts/common.ftl" as c>
<@c.page>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">${rc.getMessage("message.testname")}</th>
            <th scope="col">${rc.getMessage("message.theme")}</th>
            <th scope="col">${rc.getMessage("message.questions")}</th>
            <th scope="col">${rc.getMessage("message.write")}</th>
            <th scope="col">${rc.getMessage("message.wrong")}</th>
            <th scope="col">${rc.getMessage("message.status")}</th>
        </tr>
        </thead>
        <tbody>
        <#list successes as cc>
            <tr>
                <th scope="row">${cc.testName}</th>
                <td>${cc.testTheme}</td>
                <td>${cc.questNumber}</td>
                <td>${cc.writeAnswer}</td>
                <td>${cc.wrongAnswer}</td>
                <td>${cc.status}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>