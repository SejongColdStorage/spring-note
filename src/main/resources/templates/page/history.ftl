<#import "./_pageListTemplate.ftl" as template>

<#assign contents>

<div class="container col-lg-10">
    <div class="page-contents-wrapper row">
        <h1 class="page-name">${page.contents.name}</h1>

        <table class="table">
            <thead>
            <th>Version</th>
            <th>Date</th>
            <th>Comment</th>
            <th colspan="2">Compare</th>
            <th>Action</th>
            </thead>
            <tbody>
            <tr>
                <td>current</td>
                <td>2015/04/11 09:15:09</td>
                <td>add spring actuator part</td>
                <td><input type="checkbox"/></td>
                <td><input type="checkbox"/></td>
                <td>
                    <a>show</a>
                    <a>revert</a>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>2014/12/31 21:11:22</td>
                <td></td>
                <td><input type="checkbox"/></td>
                <td><input type="checkbox"/></td>
                <td>
                    <a>show</a>
                    <a>revert</a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>2014/09/24 12:01:40</td>
                <td></td>
                <td><input type="checkbox"/></td>
                <td><input type="checkbox"/></td>
                <td>
                    <a>show</a>
                    <a>revert</a>
                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>2014/03/10 21:11:22</td>
                <td></td>
                <td><input type="checkbox"/></td>
                <td><input type="checkbox"/></td>
                <td>
                    <a>show</a>
                    <a>revert</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</#assign>

<@template.pageDefault contents=contents/>