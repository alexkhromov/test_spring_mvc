<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
</head>

<body>

<div id="navigation">
    <ul>
        <c:forEach var="i" begin="1" end="${pages}">

            <li><a href="pageDetail.html?id=<c:out value="${i}"/>">
                Page<c:out value="${i}"/>
            </a></li>

        </c:forEach>
    </ul>
</div>

<div class="tableCommon">

    <div class="rowHeader">
        <div>Page Id</div>
        <div>Name</div>
        <div>Description</div>
        <div>Date Change</div>
    </div>

    <div class="rowRegular">
        <div><c:out value="${page.id}"/></div>
        <div><c:out value="${page.name}"/></div>
        <div><c:out value="${page.description}"/></div>
        <div><c:out value="${page.changeDate}"/></div>
    </div>

</div>

<div class="tableCommon">
    <div class="rowHeader">
        <div>Page Properties</div>
    </div>
</div>


<c:forEach var="pageProperty" items="${page.pageProperties}">

    <div class="tableCommon">
        <div class="rowRegular">
            <div style="padding-top: 3px; padding-bottom: 3px;">PageProperty<c:out value="${pageProperty.id}"/></div>
        </div>
    </div>

    <div class="tableCommon">

        <div class="rowRegular">
            <div style="width: 160px">Name</div>
            <div style="width: 160px">Default Value</div>
            <div style="width: 160px">Language Code</div>
            <div style="width: 160px">Country Code</div>
            <div style="width: 210px">Page Property Value</div>
        </div>

        <div class="rowRegular">
            <div style="width: 160px"><c:out value="${pageProperty.property.name}"/></div>
            <div style="width: 160px"><c:out value="${pageProperty.property.defaultValue}"/></div>
            <div style="width: 160px"><c:out value="${pageProperty.property.languageCode.language}"/></div>
            <div style="width: 160px"><c:out value="${pageProperty.property.languageCode.countryCode}"/></div>
            <div style="width: 210px">
                <c:forEach var="propertyValues" items="${pageProperty.pagePropertyValues}">
                    <c:out value="${propertyValues.value}"/>
                </c:forEach>
            </div>
        </div>

    </div>

</c:forEach>

</body>
</html>