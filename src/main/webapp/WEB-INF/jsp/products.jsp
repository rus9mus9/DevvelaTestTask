<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/dataTablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/productDataTables.js" defer></script>

<jsp:include page="fragments/bodyHeader.jsp"/>

    <div class="jumbotron">
        <div class="container">
                <br>
                <a class="btn btn-primary" onclick="add()">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    Add</a>
                <h3>Products</h3>
                <br/>
                    <table class="table table-striped display" id="productTable">
                        <thead>
                        <tr>
                            <th>baseId</th>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Rating</th>
                            <th style="text-align:center">Image</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="actionTitle"></h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="baseId" name="baseId">

                    <div class="form-group">
                        <label for="productId" class="control-label col-xs-3">ID</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="productId" min="1" name="productId" placeholder="ID"  >
                        </div>
                    </div>

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
                            <input type="number" class="form-control" id="price" min="1" name="price" placeholder="Price">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inetPrice" class="control-label col-xs-3">Internet Price</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="inetPrice" min="1" name="inetPrice" placeholder="Internet Price">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="rating" class="control-label col-xs-3">Rating</label>

                        <div class="col-xs-9">
                            <input  type="number" step="0.1" min="0" class="form-control" id="rating" name="rating" placeholder="Rating">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="imageURL" class="control-label col-xs-3">ImageURL</label>

                        <div class="col-xs-9">
                            <input type="url" class="form-control" id="imageURL" name="imageURL" placeholder="ImageURL">
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="button" id="onClickButton"  onclick="save()" class="btn btn-primary">
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