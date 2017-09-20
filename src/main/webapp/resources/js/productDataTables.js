var ajaxUrl = "ajax/products/";
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

// $(document).ready(function () {
$(function () {
    datatableApi = $("#productTable").DataTable({
        "paging": true,
        "info": true,
        "columns": [
            {
                "data": "productId"
            },
            {
                "data": "title"
            },
            {
                "data": "description"
            },
            {
                "data": "price"
            },
            {
                "data": "rating"
            },
            {
                "data": "imageURL",
                "orderable": false
            },
            {
                "defaultContent": "Edit",
                "orderable": false
            },
            {
                "defaultContent": "Delete",
                "orderable": false
            }
        ],
        "order": []

    });
    makeEditable();
});
