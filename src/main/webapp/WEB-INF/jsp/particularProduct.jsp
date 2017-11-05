<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<%--<jsp:useBean id="product" type="ru.parser.model.Product" scope="request"/>--%>
<head>
    <title>${product.title}</title>
</head><%----%>
<body class="jumbotron">
<script type="text/javascript" src="resources/js/dataTablesUtil.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<%--<div class="jumbotron">--%>
    <div class="container">
        <br>
        <h3>${product.title}</h3>
        <br/>
        <table class="table table-striped display" id="particularProduct">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <c:if test="${product.inetPrice != null}">
                <th style="width:15%; text-align:center">Internet Price</th>
                </c:if>
                <th style="text-align:center">Rating</th>
                <th style="text-align:center">Image</th>
            </tr>
            <tr>
                <td>${product.productId}</td>
                <td>${product.title}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <c:if test="${product.inetPrice!=null}">
                    <td align="center">${product.inetPrice}</td>
                </c:if>
                <td>${product.rating}</td>
                <td><img src="${product.imageURL}"></td>
            </tr>
            </thead>
        </table>
    </div>
<%--</div>--%>
</body>
</html>
