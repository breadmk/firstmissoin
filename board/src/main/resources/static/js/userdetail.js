let index={
	
	init:function(){
		$("#chk").on("click",()=>{
			this.chk();
		});
	},
	chk:function(){
		let userid = $("#userid").text();
		$.ajax({
			type:"post",
			url:"/member/pwdChk",
			data: $("#pwd").val(),
			contentType:"application/json; charset=utf-8",
		}).done(function(res){
			alert(res);
		});
	}	
}
index.init();