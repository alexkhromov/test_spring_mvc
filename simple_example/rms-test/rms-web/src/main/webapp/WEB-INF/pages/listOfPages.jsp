<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Pages</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/listOfPages.css"/>" />
</head>

<body>

<table class="header">
    <tr>
        <td>
            <div>
                <nav id="navigation">
                    <ul>
                        <c:forEach var="i" begin="1" end="${pages}">

                            <li><a href="pageDetail.html?id=<c:out value="${i}"/>">
                                Page<c:out value="${i}"/>
                            </a></li>

                        </c:forEach>
                    </ul>
                </nav>
            </div>
        </td>
    </tr>
</table>
</body>
</html>