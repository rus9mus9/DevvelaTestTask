<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page ="fragments/bodyHeader.jsp"/>

<section>
    <h3>AAAAAAAA</h3>
<form method="post" action="products" enctype="multipart/form-data">
    Select a file from the computer <input type="file" name="file">
    <br>
    Or load from URL<input type="url" name="urlFile">
    <br>
<button type="submit">Парсануть!</button>

</form>
</section>
</body>
</html>
