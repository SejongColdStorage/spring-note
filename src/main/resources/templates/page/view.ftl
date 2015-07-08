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
    <style>
        html, body {
            overflow-x: hidden; /* Prevent scroll on narrow devices */
        }

        body {
            padding-top: 70px;
        }

        footer {
            padding: 30px 0;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
        <!-- /.nav-collapse -->
    </div>
    <!-- /.container -->

</nav>
<!-- /.navbar -->

<nav class="sidebar col-lg-2">
    <div class="note-metadata">
        <div>
            <span>name :</span> ${note.name}
        </div>
        <div>
            <span>author :</span> sejong park
        </div>
    </div>
    <div class="page-list">
        <ul>
        <#list pageList as page>
            <li>
                <a href="/note/${note.urlPath}/${page.id}">${page.name}</a>
            </li>
        </#list>
        </ul>
    </div>
</nav>
<!-- /.sidebar-->

<article class=" col-lg-9">

    <div class="page-action row">
        <div class="btn-group">
            <a href="/note/${note.urlPath}/${page.id}/create" class="btn btn-default">Add Child Page</a>
            <a href="/note/${note.urlPath}/${page.id}/edit" class="btn btn-default">Edit Page</a>
            <a href="/note/${note.urlPath}/${page.id}/history" class="btn btn-default">Page History</a>
            <a href="/note/${note.urlPath}/${page.id}/delete" class="btn btn-default">Delete Page</a>
            <a href="/note/${note.urlPath}/${page.id}/move" class="btn btn-default">move</a>
            <a href="/note/${note.urlPath}/${page.id}/info" class="btn btn-default">Page Info</a>
        </div>
    </div>

    <div class="page-contents-wrapper row">
        <h1 class="page-name">${page.name}</h1>

        <div class="page-contents">
        ${page.parsedContents}
        </div>
    </div>

</article>

<script src="//cdn.jsdelivr.net/jquery/2.1.4/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>

</html>
