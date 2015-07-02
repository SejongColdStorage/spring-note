<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Index</title>

    <link href="//cdn.jsdelivr.net/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css" media="screen">
        #editor {
            position: relative;
            height: 500px;
            margin : 10px 0;
        }
    </style>
</head>

<body>

<div class="col-lg-12">

    <div class="editor-layer">
        <input type="text" value="${pageContents.name}">
        <div id="editor">${pageContents.rawContents}</div>
    </div>

    <div>
        <button class="save-button">저장</button>
        <button class="cancel-button">취소</button>
    </div>
</div>

<script src="//cdn.jsdelivr.net/jquery/2.1.4/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/ace/1.1.9/ace.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/ace/1.1.9/mode-markdown.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/ace/1.1.9/theme-monokai.js"></script>
<script>
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/markdown");
</script>

</body>

</html>
