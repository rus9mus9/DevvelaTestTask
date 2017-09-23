<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<section>
    <jsp:useBean id="product" type="ru.parser.model.Product" scope="request"/>
    <h3>${product.isNew() ? "Add product" : "Edit Product"}</h3>
    <hr>
    <form method = "post" action = "products">
        <dl>
            <dt>ID:</dt>
            <dd><input type="number" value="${product.productId}" name="productId"></dd>
        </dl>
        <dl>
            <dt>Title:</dt>
            <dd><input type="text" value="${product.title}" name="title"></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${product.description}" name="description"></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><input type="number" value="${product.price}" name="price"></dd>
        </dl>
        <dl>
            <dt>Rating:</dt>
            <dd><input type="number" step="any"  value="${product.rating}" name="rating"></dd>
        </dl>
        <dl>
            <dt>Internet Price:</dt>
            <dd><input type="number" value="${product.inetPrice}" name="inetPrice"></dd>
        </dl>
        <dl>
            <dt>Image:</dt>
            <dd><input type="file" value="${product.image}" name="image"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
