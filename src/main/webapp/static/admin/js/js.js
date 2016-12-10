
//footerdocument.body.scrollHeight
window.onload = function () {
    document.getElementById("footer").style.top = (document.body.scrollHeight+20) + 'px'
}



$(function(){
	$(".nav_mobile img").click(function(){
		$(".nav").toggle();
		 
		
	})
})





