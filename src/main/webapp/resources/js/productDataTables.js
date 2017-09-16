var ajaxUrl = "ajax/products/";
var datatableApi;

// $(document).ready(function () {
$(function () {
    datatableApi = $("#datatable").DataTable({
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
                "data": "image"
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
