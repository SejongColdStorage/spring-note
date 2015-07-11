<#import "../_defaultTemplate.ftl" as template>

<#assign css>
<style>
    #markdownEditor {
        position: relative;
        height: 500px;
    }

    .page-editor-wrapper {
        border: 1px solid black;
    }

    .page-edit-action {
        background: lightgray;
    }
</style>
</#assign>

<#assign contents>
<div class="container">
    <div class="page-contents row">
        <div class="row page-name-wrapper">
            <input type="text" class="page-name form-control input-lg" value="${page.contents.name!}">
        </div>
        <hr>
        <div class="page-editor-wrapper">
            <div class="editor-layer col-lg-6" id="markdownEditor">${page.contents.rawContents!}</div>
            <div class="preview-layer  col-lg-6">${page.contents.parsedContents!}</div>
        </div>
    </div>
    <!--page-contents-->

    <div class="page-edit-action row">
        <div class="btn-group">
            <button class="btn-save-page btn btn-default">
                <span class="save-loading-icon hidden">
                    <i class="fa fa-spinner fa-pulse"></i>
                </span>
                Save
            </button>
            <button class="btn-cancel-edit btn btn-default">Cancel</button>
        </div>
    </div>
    <!--/edit-action-->

</div>
<!--/container -->


<form class="form-page-edit hidden" method="post">
    <input type="text" id="pageName" name="pageName">
    <input type="text" id="pageRawConents" name="pageRawConents">
</form>

</#assign>

<#assign script>
<script src="//cdnjs.cloudflare.com/ajax/libs/ace/1.1.9/ace.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/ace/1.1.9/mode-markdown.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/ace/1.1.9/theme-chrome.js"></script>

<script>
    var editor = ace.edit("markdownEditor");
    editor.setTheme("ace/theme/chrome");
    editor.getSession().setMode("ace/mode/markdown");

    //event listener
    $(".btn-save-page").on("click", function () {
        // send data to server
        // first show loading icon
        $(".save-loading-icon").removeClass("hidden");
        $(".btn-save-page").attr("disabled", "disabled");

        //TODO remove dependency with freemarker.
        $(".form-page-edit").attr("action", window.location.href);
        $(".form-page-edit > name[pageName]").val($(".page-name").val());
        $(".form-page-edit > name[pageRawConents]").val(editor.getSession().getValue());
        $(".form-page-edit").submit();
    });

    $(".btn-cancel-edit").on("click", function () {
        alert("not yet implements!!");
    });
</script>
</#assign>

<@template.default title="${page.contents.name}" contents=contents script=script css=css/>
