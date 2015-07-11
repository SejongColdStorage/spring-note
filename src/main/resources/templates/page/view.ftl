<#import "./_pageListTemplate.ftl" as template>

<#assign contents>
<article class="col-lg-10">

    <div class="page-action row">
        <div class="btn-group">
            <a href="/note/${note.urlPath}/${page.id}/add" class="btn-page-add btn btn-default">Add Child Page</a>
            <a href="/note/${note.urlPath}/${page.id}/edit" class="btn-page-edit btn btn-default">Edit Page</a>
            <a href="/note/${note.urlPath}/${page.id}/history" class="btn-page-history btn btn-default">Page History</a>
            <a href="/note/${note.urlPath}/${page.id}/delete" class="btn-page-delete btn btn-default">Delete Page</a>
            <a href="/note/${note.urlPath}/${page.id}/move" class="btn-page-move btn btn-default">move</a>
            <a href="/note/${note.urlPath}/${page.id}/info" class="btn-page-info btn btn-default">Page Info</a>
        </div>
    </div>

    <div class="page-contents-wrapper row">
        <h1 class="page-name">${page.contents.name}</h1>

        <div class="page-contents">
        ${page.contents.parsedContents}
        </div>
    </div>
</article>
</#assign>

<script>
    $(".btn-page-delete").on("click", function(e){
        if(false === confirm("All data will be deleted. Are you sure you wish to proceed?")){
            e.preventDefault();
        }
    });
</script>

<@template.pageDefault title="${page.contents.name}" contents=contents/>