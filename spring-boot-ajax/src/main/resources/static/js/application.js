//created category
function openModalCategory(){
	$("#modalCategory").modal('show');
	$("#formCategory")[0].reset();
}

//reload category
function reloadCategory(){
	$("#tabel-category").DataTable().ajax.reload();
}

//reload book
function reloadBook(){
    $("#tabel-book").DataTable().ajax.reload();
}

//open modal buku
function openBuku(){
	$("#modalbook").modal('show');
	$("#formBook")[0].reset();
}

//list category modal
$(document).on('click', '.getid', function(){
    $("#modal_list").modal('show');
});

//save book
$(document).on('click', '.savedbook', function(){

    var title = $("#title_book").val();
    var author = $("#author_book").val();
    var price = $("#price_book").val();
    var quantity = $("#quantity_book").val();
    var idcategory = $("#category_idcategory").val();

    $.ajax({
        type: 'POST',
        url: '/api/book/created/'+idcategory,
        data: JSON.stringify({
            title: title,
            author: author,
            price: price,
            quantity: quantity,
            idcategory: idcategory
        }),
        contentType: "application/json;charset=UTF-8",
        dataType: 'JSON',

        complete:function(){
            reloadBook();
            alert('data berhasil disimpan');
            $("#modalbook").modal('hide');
        }
    });

});

//ambil category
$(document).on('click', '.ambil', function(){

    var idcategory = $(this).attr("data-id");

    $.ajax({
        url : '/api/category/'+idcategory,
        method: 'GET',
        success: function(response){
            document.getElementById("category_idcategory").value = response.idcategory;
            document.getElementById("category_nama").value = response.name;
            console.log("ambil data : "+response.idcategory +" | "+response.name);
            $("#modal_list").modal('hide');
            alert("data "+response.name+" berhasil diambil");
        }
    });

});

$(document).on('click', '.saved', function(){
	
	var name = $("#name_of_category").val();
	
	$.ajax({
		url:'/api/category/created',
		type: 'POST',
		data: JSON.stringify({name:name}),
		contentType:'application/json;charset=UTF-8',
		dataType: 'JSON',
		
		complete:function(response){
			console.log(response);
			$("#modalCategory").modal('hide');
			reloadCategory();
			alert('data berhasil ditambahkan !');
		}
	});

});

$(document).on('click', '.edited', function(){
	
	var idcategory = $("#update_idcategory").val();
	var name = $("#update_name").val();
	var disabled = $("#update_disabled").val();
	
	$.ajax({
		url: '/api/category/updated',
		type: 'POST',
		data: JSON.stringify({idcategory:idcategory, name:name, disabled:disabled}),
		contentType:'application/json;charset=UTF-8',
		dataType: 'JSON',
		
		complete:function(response){
			console.log(response);
			$("#modalCategoryUpdate").modal('hide');
			reloadCategory();
			alert('data berhasil diupdate !');
		}
	});
	
});


$(document).on('click', '.editCategory', function(){
	
	var idcategory = $(this).attr('data-id');
	
	$.ajax({
		url :'/api/category/'+idcategory,
		method: 'GET',
		success:function(response){
			console.log("ambil data : "+response.idcategory+ " | "+response.name+" | "+response.disabled);
			$('[name = "idcategory"]').val(response.idcategory);
			$('[name = "name"]').val(response.name);
			$('#update_disabled option[value="'+response.disabled+'"]').prop('selected', true);
			$("#modalCategoryUpdate").modal('show');
		}
	});
	
});




$(document).ready(function(){
	
	var tabelBook = $("#tabel-book");
	
	if(tabelBook.length){
		
		tabelBook.DataTable({
			lengthMenu: [[3, 5, -1], ['Show 3', 'Show 5', 'Show All']],
			pageLength: 3,
			ajax: {
				url : '/api/book',
				dataSrc: ''
			},
			columns : [
				{
					data : 'idbuku'
				},
				{
					data : 'title'
				},
				{
					data : 'author'
				},
				{
					data : 'quantity'
				},
				{
					data : 'price'
				},
				{
					data : 'category.name'
				},
				{
					data : 'disabled'
				},
				{
					data : 'idbuku',
					mRender:function(data, type, row){
						
						var str = "";
						
						str += "<button class='btn btn-primary'>";
						str += "<span class='glyphicon glyphicon-pencil'></span>";
						str += "</button>";
						
						str += "<button class='btn btn-danger'>";
						str += "<span class='glyphicon glyphicon-trash'></span>";
						str += "</button>";
						
						return str;
					}
				}
			]
		});
	}
	
});

//list category
$(document).ready(function(){

    var listcategory = $("#listcategory");

    if(listcategory.length){

        listcategory.DataTable({
            lengthMenu: [[3, 5, -1], ['show 3', 'show 5', 'show all']],
            pageLength: 3,
            ajax:{
                url: '/api/category',
                dataSrc: ''
            },
            columns:[
                {
                    data: 'name'
                },
                {
                    data: 'idcategory',
                    bSortable: false,
                    mRender:function(data, type, row){

                        var str = "";

                        str += "<button class='btn btn-default ambil' data-id='"+data+"'><span class='glyphicon glyphicon-plus-sign'>";
                        str += "</span>Ambil</button>";

                        return str;
                    }
                }
            ]
        });
    }

});


$(document).ready(function(){
	
    var tabelCategory = $("#tabel-category");

    if(tabelCategory.length){

        tabelCategory.DataTable({
            lengthMenu : [[3, 5, 10, -1], ['Tampilkan 3', 'Tampilkan 5', 'Tampilkan 10', 'Tampilkan Semua']],
            pageLength: 3,
            ajax:{
                url: '/api/category',
                dataSrc: ''
            },
            columns : [
                {
                    data : 'idcategory'
                },
                {
                    data: 'name'
                },
                {
                    data: 'disabled',
                    mRender:function(data, type, row){
                        if(data == true){
                            return "<span class='label label-default'>True</span>";
                        }else{
                            return "<span class='label label-danger'>False</span>";
                        }
                    }
                },
                {
                    data: 'idcategory',
                    bSortable: false,
                    mRender:function(data, type, row){

                        var str = "";

                        str += '<button class="btn btn-primary editCategory" data-id="'+data+'"><span class="glyphicon glyphicon-pencil">';
                        str += '</span></button>';
                        str += '<button class="btn btn-danger"><span class="glyphicon glyphicon-trash">';
                        str += '</span></button>';

                        return str;
                    }
                }
            ]
        });
    }

});