//let index ={
//	
//	init:function(){
//		$(".deleteOk").on("click",()=>{
//			var no = $(this);
//			console.log(no);
//		});
//	}
//}
//index.init()

$(function(){
	$(".deleteOk").click(function(){
		let no = $(this).parents('tr').find("#no").text();
		if(confirm("정말 탈퇴시키겠습니까?")==true)
			location.href="/member/admin/deleteOk/"+no;
		else
			location.href="/member/admin";
	});
	
	$(".email").click(function(){
		let no = $(this).parents('tr').find("#no").text();
		location.href="/member/email/"+no;
	});
	
	
});