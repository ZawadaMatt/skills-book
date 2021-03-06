<%--
  Created by IntelliJ IDEA.
  User: mateu
  Date: 24.10.2019
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
    <title>SkillsBook</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="hero-body">
<div class="columns">
    <div class="column is-1">

    </div>
    <div class="column is-one-third">
        <p class="title is-3 is-spaced">Log in</p>
        <p class="title is-3 is spaced">
            <input class="input is-rounded" type="text" placeholder="Username">
        </p>
        <input class="input is-rounded" type="password" placeholder="Password">
    </div>
    <div class="column">
    </div>
</div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
