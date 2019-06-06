<#import "parts/common.ftl" as c>
<@c.page>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">User name</th>
            <th scope="col">Tests</th>
            <th scope="col">Passed</th>
            <th scope="col">Failed</th>
            <th scope="col">Activity</th>
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