<#import "parts/common.ftl" as c>
<@c.page>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Test name</th>
            <th scope="col">Theme</th>
            <th scope="col">Questions</th>
            <th scope="col">Write</th>
            <th scope="col">Wrong</th>
            <th scope="col">Status</th>
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