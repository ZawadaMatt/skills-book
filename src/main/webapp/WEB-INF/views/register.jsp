<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 24.10.2019
  Time: 19:03
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
<form action="register" method="post">
<div class="columns">
    <div class="column">
    </div>
    <div class="column">
        <h2>Register</h2>
        <input class="input is-rounded" type="text" placeholder="Username" name="username">
        <input class="input is-rounded" type="password" placeholder="Password" name="password">
        <input class="input is-rounded" type="text" placeholder="First Name" name="firstName">
        <input class="input is-rounded" type="text" placeholder="Last Name" name="lastName">
        <button class="button is-primary" type="submit">Submit</button>
    </div>
    <div class="column">

    </div>
</div>
</form>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
