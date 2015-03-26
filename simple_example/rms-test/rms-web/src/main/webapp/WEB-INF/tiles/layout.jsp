<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

    <tiles:insertAttribute name="header"/>

    <div class="container">
        <tiles:insertAttribute name="body" defaultValue=""/>
    </div>

</body>
</html>

