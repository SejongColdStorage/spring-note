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
</head>

<body>

<div class="wrapper">
    <div class="col-lg-2">
        <ul class="nav nav-pills nav-stacked">
        <#list pageList as page>
            <li>
                <a href="/note/${page.id}">${page.name}</a>
            </li>
        </#list>
        </ul>
    </div>

    <div class="col-lg-9">
        <h1 class="page-header">${pageContents.name}</h1>

        <div class="note-contents">
        ${pageContents.parsedContents}
        </div>
    </div>
</div>

<script src="//cdn.jsdelivr.net/jquery/2.1.4/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>

</html>
