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
        var url = window.location.href;
        var pageData = {
            name: $(".page-name").val(),
            rawContents: editor.getSession().getValue()
        };

        $.post(url, pageData).done(function (result) {
            location.href = result;
        }).error(function (result) {
            console.log(result);
        }).always(function () {
            $(".save-loading-icon").addClass("hidden");
            $(".btn-save-page").removeAttr("disabled");
        })
    });

    $(".btn-cancel-edit").on("click", function () {

    });
</script>
</#assign>

<@template.default title="${page.contents.name}" contents=contents script=script css=css/>
