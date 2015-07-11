<#import "./_pageListTemplate.ftl" as template>

<#assign contents>
<div class="container col-lg-10">
    <div class="page-contents-wrapper row">
        <h1 class="page-name">${page.contents.name}</h1>

        <table class="table">
            <thead>
            <tr>
                <th>Version</th>
                <th>Date</th>
                <th>Comment</th>
                <th colspan="2">Compare</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <!-- 현재버전은 페이지의 contents를 노출한다. -->
            <tr>
                <td>current</td>
                <td>${page.contents.modifiedDate}</td>
                <td>${page.contents.editComment!}</td>
                <td><input type="checkbox"/></td>
                <td><input type="checkbox"/></td>
                <td>
                    <button class="btn-page-show btn btn-default">show</button>
                    <button class="btn-page-revert btn btn-default">revert</button>
                </td>
            </tr>
                <#list page.pageHistories as pageHistory>
                <tr>
                    <td>v${pageHistory.version}</td>
                    <td>${pageHistory.contents.modifiedDate}</td>
                    <td>${pageHistory.contents.editComment!}</td>
                    <td><input type="checkbox"/></td>
                    <td><input type="checkbox"/></td>
                    <td>
                        <button class="btn-page-show btn btn-default">show</button>
                        <button class="btn-page-revert btn btn-default">revert</button>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</#assign>

<#assign script>
<script>
    $(".btn-page-show").on("click", function (e) {
        alert("작업필요");
    });

    $(".btn-page-revert").on("click", function (e) {
        alert("작업필요");
    });
</script>
</#assign>

<@template.pageDefault contents=contents script=script/>