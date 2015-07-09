<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Page Editor</title>

    <link href="//cdn.jsdelivr.net/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css" media="screen">
        html, body {
            overflow-x: hidden; /* Prevent scroll on narrow devices */
        }

        body {
            padding-top: 70px;
        }

        footer {
            padding: 30px 0;
        }

        #markdownEditor {
            position: relative;
            height: 500px;
        }

        .page-editor-wrapper {
            border: 1px solid black;
        }

        .page-action {
            background: lightgray;
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
                <a href="/note/${note.urlPath}/${page.id}">${page.contents.name}</a>
            </li>
        </#list>
        </ul>
    </div>
</nav>
<!-- /.sidebar-->

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

<script src="//cdn.jsdelivr.net/jquery/2.1.4/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>

</html>
