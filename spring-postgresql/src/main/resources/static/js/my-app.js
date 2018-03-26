function newbook(){
    $("#modal-book").modal('show');
    $("#form-book")[0].reset();
}

function newcategory(){
    $("#modal-category").modal('show');
    $("#form-category")[0].reset();
}


function refresh_tabel_category(){
    $("#tabel-category").DataTable().ajax.reload();
}

function refresh_tabel_book(){
    $("#tabelbook").DataTable().ajax.reload();
}

//insert category
function insert_category(){
     var name_of_category = $("#insert_name").val();

        $.ajax({
            url: '/api/category/created',
            type: 'POST',
            data: JSON.stringify({name:name_of_category}),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'JSON',

            complete:function(){
                $("#modal-category").modal('hide');
                refresh_tabel_category();
                alert('inserted has been successfully !');
            }
      });
}

//inserted book
function insert_book(){

    var title_of_book = $("#title").val();
    var quantity_of_book = $("#quantity").val();
    var price_of_book = $("#price").val();
    var author_of_book = $("#author").val();
    var idcategory_of_book = $("#idcategory").val();

    $.ajax({
        type: "POST",
        url: "/api/book/saved/"+idcategory_of_book,
        data: JSON.stringify({
            title: title_of_book,
            author: author_of_book,
            quantity: quantity_of_book,
            price: price_of_book,
            idcategory: idcategory_of_book
        }),
        contentType: "application/json;charset=UTF-8",
        dataType: "JSON",

        complete: function(){
            $("#modal-book").modal('hide');
            refresh_tabel_book();
            alert('successfully !');
            console.log("201 HttpStatus Created");
        }
    });
}

//update category
function update_category(){

    var name_of_category = $("#update_name").val();
    var code_of_category = $("#idcategory").val();
    var disabled_of_category = $("#disabled").val();

    $.ajax({
        url: '/api/category/updated',
        type: 'POST',
        data: JSON.stringify({idcategory:code_of_category,
        name:name_of_category,
        disabled:disabled_of_category}),
        contentType: 'application/json;charset=UTF-8',
        dataType: 'JSON',

        complete:function(){
            $("#modal-category-update").modal('hide');
            refresh_tabel_category();
            alert('updated has been successfully !');
        }
    });
}

//get idcategory
$(document).on('click', '.edt', function(){

    var idcategory = $(this).attr('data-id');
    $.ajax({
        url: '/api/category/'+idcategory,
        method: 'GET',
        success: function(responses){
            console.log("oke "+responses.idcategory);
            $('[name="idcategory"]').val(responses.idcategory);
            $('[name="name"]').val(responses.name);
            $('#disabled option[value="'+responses.disabled+'"]').prop('selected', true);
            $("#modal-category-update").modal('show');
        }
    });
});

//list modal
$(document).on('click', '#modal-list', function(){
    $("#modal-list-category").modal('show');
});

//combobox
//$(document).ready(function(){

//    var values = "";
  //  $.ajax({
    //    url: '/api/category',
      //  type: 'GET',
        //dataType:'json',
        //contentType: 'application/json;charset=UTF-8',
        //success:function(responses){
          //  $.each(responses, function(key, category){
            //    $("#idcategory").append($("<option></option>")
              //  .attr("category",category.idcategory).text(category.name));
            //});
       // }
    //});
//});

$(document).ready(function(){

    var tabelcategory = $("#tabel-category");

    if(tabelcategory.length){

        tabelcategory.DataTable({

            lengthMenu : [[3, 5, -1], ['Show Three', 'Show Five', 'Show All']],
            pageLength: 3,
            ajax: {
                url: '/api/category',
                dataSrc: ''
            },
            columns: [
                {data: 'idcategory'},
                {data: 'name'},
                {
                    data: 'disabled',
                    mRender:function(data, type, row){
                        if(data == true){
                            return '<span class="label label-default">True</span>';
                        }else{
                            return '<span class="label label-danger">False</span>';
                        }
                    }
                },
                {
                    data: 'idcategory',
                    bSortable: false,
                    mRender:function(data, type, row){

                        var str = "";

                        str+="<button class='btn btn-primary edt' data-id='"+data+"'><span class='glyphicon glyphicon-pencil'></span></button> ";
                        str+="<button class='btn btn-primary'><span class='glyphicon glyphicon-trash'></span></button>";
                        return str;
                    }
                }
            ]
        });
    }
});

//get idcategory insert into text field
$(document).on('click', '.getid', function(){

    var idcategory = $(this).attr("data-id");
    $.ajax({
        url: '/api/category/'+idcategory,
        method: 'GET',
        success:function(responses){
            document.getElementById("idcategory").value = responses.idcategory;
            document.getElementById("namecategory").value = responses.name;
            console.log("category->idcategory : "+responses.idcategory+" | "+"name : "+responses.name);
            $("#modal-list-category").modal('hide');
        }
    });
});

//tabel-list-category
$(document).ready(function(){

    var tabel_list_category = $("#tabel-list-category");

    if(tabel_list_category.length){

        tabel_list_category.DataTable({

            lengthMenu: [[5, 10, 20, -1], ['5', '10', '20', 'All']],
            pageLength: 10,
            ajax:{
                url: '/api/category',
                dataSrc: ''
            },
            columns: [
                {data: 'name'},
                {
                    data: 'disabled',
                    mRender:function(data, type, row){
                        if(data == true){
                            return '<span class="label label-default">True</span>';
                        }else{
                            return '<span class="label label-danger">False</span>';
                        }
                    }
                },
                {
                    data: 'idcategory',
                    bSortable: false,
                    mRender: function(data, type, row){

                        var str = "";

                        str += "<button class='btn btn-default getid' data-id='"+data+"'>";
                        str += "<span class='glyphicon glyphicon-ok'>"
                        str += "</span></button>";

                        return str;
                    }
                }
            ]
        });
    }

});

//tabel book
$(document).ready(function(){

    //list data buku
    var tabelbook = $("#tabelbook");

    if(tabelbook.length){

        tabelbook.DataTable({

            lengthMenu: [[3, 5, -1], ['Tampilkan 3', 'Tampilkan 5', 'Tampilkan Semua']],
            pageLength: 5,
            ajax: {
                url: '/api/book',
                dataSrc: ''
            },
            columns : [
                {data : 'idbuku'},
                {data : 'title'},
                {data : 'author'},
                {data : 'quantity'},
                {data : 'category.name'},
                {
                    data : 'disabled',
                    mRender:function(data, type, row){
                        if(data == true){
                            return "<span class='label label-default'>True</span>";
                        }else{
                            return "<span class='label label-danger'>False</span>";
                        }
                    }
                },
                {
                    data: 'idbuku',
                    bSortable: false,
                    mRender: function(data, type, row){

                        var str = "";

                        str+='<button class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button> ';
                        str+='<button class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span></button>';
                        return str;
                    }
                }
            ]
       });
    }
});