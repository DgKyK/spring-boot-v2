<#import "parts/common.ftl" as c>
<@c.page>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">${rc.getMessage("message.username")}</th>
            <th scope="col">${rc.getMessage("message.tests")}</th>
            <th scope="col">${rc.getMessage("message.passed")}</th>
            <th scope="col">${rc.getMessage("message.failed")}</th>
            <th scope="col">${rc.getMessage("message.activity")}</th>
        </tr>
        </thead>
        <tbody>
        <#list statistic as stat>
        <tr>
            <th scope="row">${stat.userName}</th>
            <td>${stat.tests}</td>
            <td>${stat.passed}</td>
            <td>${stat.failed}</td>
            <td>${stat.activity}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</@c.page>