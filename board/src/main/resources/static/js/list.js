$(function(){
	
	$(".contentRow").click(function(){
		var no = $(this).find("#no").text();
		location.href="/board/content/"+no;
	});
	
	$("#register").click(function(){
		location.href="/board/register";	
	})
})