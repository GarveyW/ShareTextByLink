<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>User Request</title>

    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">ShareLink</a></li>
                <li><a href="about">About</a></li>
                <li><a href="contact">Contact</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <form role="form" action="save" method="post">
        <div class="form-group">
            <label for="content">Put here your text</label>
            <input type="text" class="form-control" id="content" name="content" placeholder="Some text">
        </div>
        <button type="submit" class="btn btn-default">Share!</button>
    </form>
</div>
</body>
</html>