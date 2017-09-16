<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/dataTablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/productDataTables.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>
    <div class="jumbotron">
        <div class="container">
            <div class="shadow">
                <br>
                <a class="btn btn-primary" onclick="add()">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    Add
                </a><h3>Products</h3>
                <br/>

                <div class="view-box">
                    <table class="table table-striped display" id="datatable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Rating</th>
                            <th>Image</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <c:forEach items="${products}" var="product">
                            <jsp:useBean id="product" scope="page" type="model.Product"/>
                        <tr>
                            <td>${product.productId}</td>
                            <td>${product.title}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.rating}</td>
                            <td><img alt="img" src="data:image/jpeg;base64,${product.base64ImageFile}"/></td>
                            <td><a><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                            <td><a class = "delete" onclick="deleteRow(${product.productId})"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Add a Product</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="productId" name="productId">

                    <div class="form-group">
                        <label for="title" class="control-label col-xs-3">Title</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="title" name="title" placeholder="Title">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="description" class="control-label col-xs-3">Description</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="description" name="description" placeholder="Description">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="price" class="control-label col-xs-3">Price</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="price" name="price" placeholder="Price">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="rating" class="control-label col-xs-3">Rating</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="rating" name="rating" placeholder="Rating">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="image" class="control-label col-xs-3">Image</label>

                        <div class="col-xs-9">
                            <input type="image" class="form-control" id="image" name="rating" placeholder="Image">
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>