let index={
	
	init:function(){
		$("#chk").on("click",()=>{
			this.chk();
		});
		$("#chk2").on("click",()=>{
			this.chk2();
		});
	},
	chk:function(){
		$.post({
			type:"POST",
			url:"/member/pwdChk",
			data:$("#pwd").val(),
			contentType:"application/json; charset=utf-8",
		}).done(function(res){
			alert(res);
			if(res.match("일치"))
				$("#pwd2").focus();
			else
				$("#pwd").focus();
		});
	},
	
	chk2:function(){
		$.post({
			type:"post",
			url:"/member/pwdChkOk",
			data:$("#pwd2").val(),
			contentType:"application/json; charset=utf-8",
		}).done(function(res){
			alert(res)
		});
	}
		
}
index.init();




