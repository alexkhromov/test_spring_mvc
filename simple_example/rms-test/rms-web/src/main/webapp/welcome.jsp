<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Welcome</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/welcome.css"/>" />

    <script type="text/javascript" src="<c:url value="/resources/javascript/util.js" />" ></script>

</head>

<body onload="setContainerWidth()">

<div id="container">

    <div id="header">SPRING - MVC - TEST</div>

    <div id="start">
        <ul>
            <li><a href="pages.html">Start test</a></li>
        </ul>
    </div>

</div>

</body>
</html>