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

<div class="wrapper">
    <div class="col-lg-2">
        <div class="note-data">
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
    </div>

    <div class="col-lg-9">
        <div class="page-action row">
            <div class="btn-group">
                <button class="btn btn-default">Add Child Page</button>
                <button class="btn btn-default">Edit Page</button>
                <button class="btn btn-default">Page History</button>
                <button class="btn btn-default">Delete Page</button>
                <button class="btn btn-default">Change Parent</button>
                <button class="btn btn-default">Page Info</button>
            </div>
        </div>
        <div class="page-contents row">
            <h1 class="page-header">${pageContents.name}</h1>

            <div class="note-contents">
            ${pageContents.parsedContents}
            </div>
        </div>
    </div>
</div>

<script src="//cdn.jsdelivr.net/jquery/2.1.4/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>

</html>
