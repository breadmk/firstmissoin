
function list(){
	location.href="/list";
}

function update(){
	var no = $("#no").text();
	location.href="/board/update/"+no;
}

function deleteOk(){
	var no = $("#no").text();
	if(confirm("정말 삭제하시겠습니까?") == true){
		location.href="/board/deleteOk/"+no;
	}else{
		location.href="/board/content/"+no;
	}
}
