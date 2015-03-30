<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/welcome.css"/>"/>

    <script type="text/javascript" src="<c:url value="/resources/javascript/util.js" />"></script>

</head>
<body onload="setContainerWidth();setTitle()">

<div id="container">

    <tiles:insertAttribute name="header"/>

    <tiles:insertAttribute name="body" defaultValue=""/>

</div>

</body>
</html>

