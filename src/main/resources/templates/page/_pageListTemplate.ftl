<#import "../_defaultTemplate.ftl" as template>

<#macro pageListPartial pageList>
<ul>
    <#list pageList as page>
        <li>
            <a href="/note/${note.urlPath}/${page.id}">${page.contents.name}</a>
            <#if page.childPages?has_content>
                <@pageListPartial pageList=page.childPages/>
            </#if>
        </li>
    </#list>
</ul>
</#macro>

<#macro pageDefault title="Spring Note" css="" script="" contents="">

    <#assign internalContents>
    <nav class="sidebar col-lg-2">
        <div class="note-metadata">
            <div>
                <span>name :</span> ${note.name}
            </div>
            <div>
                <span>author :</span> sejong park
            </div>
        </div>
        <hr/>
        <div class="page-list">
            <@pageListPartial pageList=pageList/>
        </div>
    </nav>
    <!-- /.sidebar-->

    ${contents}

    </#assign>

    <@template.default title=title css=css script=script contents=internalContents/>
</#macro>