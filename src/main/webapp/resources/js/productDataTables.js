var ajaxUrl = "ajax/products/";
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

// $(document).ready(function () {
$(function () {
    datatableApi = $("#productTable").DataTable({
        "ajax":
            {
              "url":ajaxUrl,
               "dataSrc":""
            },
        "paging": true,
        "info": true,
        "columns": [
            {
                "data": "baseId",
                "visible": false,
                "searchable": false
            },
            {
                "data": "productId"
            },
            {
                "data": "title",
                "render": function(data, type, row)
                {
                    if(type === "display")
                    {
                        return '<a href="products/product/' + row.baseId + '">' + data + '</a>';
                    }
                    return data;
                }

            },
            {
                "data": "description"
            },
            {
                "data": "price"
            },
            {
                "data": "rating",
                "render": $.fn.dataTable.render.number('.','.', 1)
            },
            {
                "data": "imageURL",
                "render": function(data, type, row)
                {
                    if(type === "display")
                    {
                     return '<a href="products/product/' + row.baseId + '"><img src='+data+' />'+'</a>';
                    }
                    return data;
                },
                "orderable": false
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        "order": [[0, "asc"]]
    });
    makeEditable();
});
