<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Page Detail</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/listOfPages.css" />" />
</head>

<body>
<table>
    <tr>
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
    </tr>

    <tr>
        <div id="container">
            <table class="body" border="3">

                <tr class="rowheader">
                    <td>Page Id</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td colspan="2">Date Change</td>
                </tr>

                <tr>
                    <td><c:out value="${page.id}"/></td>
                    <td><c:out value="${page.name}"/></td>
                    <td><c:out value="${page.description}"/></td>
                    <td colspan="2"><c:out value="${page.changeDate}"/></td>
                </tr>

                <tr class="rowheader">
                    <td colspan="5">Page Properties</td>
                </tr>

                <c:forEach var="pageProperty" items="${page.pageProperties}">

                    <tr>
                        <td colspan="5">PageProperty<c:out value="${pageProperty.id}"/></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>Default Value</td>
                        <td>Language Code</td>
                        <td>Country Code</td>
                        <td>Page Property Value</td>
                    </tr>
                    <tr>
                        <td><c:out value="${pageProperty.property.name}"/></td>
                        <td><c:out value="${pageProperty.property.defaultValue}"/></td>
                        <td><c:out value="${pageProperty.property.languageCode.language}"/></td>
                        <td><c:out value="${pageProperty.property.languageCode.countryCode}"/></td>
                        <c:forEach var="propertyValues" items="${pageProperty.pagePropertyValues}">
                            <td><c:out value="${propertyValues.value}"/></td>
                        </c:forEach>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </tr>
</table>
</body>
</html>