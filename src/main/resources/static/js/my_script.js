$(document).ready(function() {
	start_pagination()
	ellipsis($('.normal .description p'), 200);
	ellipsis($('.text .description p'), 400);
});

function start_pagination() {
	var items = $(".blog-card");
	var numItems = items.length;
	var perPage = 2;
	items.slice(perPage).hide();
	if(items.length > perPage){
		$('#pagination-container').show()
	}else{
		$('#pagination-container').hide()
	}
	$('#pagination-container').pagination({
		items : numItems,
		itemsOnPage : perPage,
		prevText : "&laquo;",
		nextText : "&raquo;",
		onPageClick : function(pageNumber) {
			var showFrom = perPage * (pageNumber - 1);
			var showTo = showFrom + perPage;
			items.hide().slice(showFrom, showTo).show();
		}
	});
}

function ellipsis(elem, max) {
	elem.each(function() {
		var textLength = $(this).text().length;
		var text = $(this).text();
		if (textLength > max) {
			$(this).text(text.substr(0, max - 3) + '…');
		};
	});
};


function send_comment(idNews){
	
	var comment = $("#text_comment").val();
	
	$.ajax({
        url: "/api/comment/"+idNews,
        contentType: 'application/json',
        dataType: 'json',
        data:JSON.stringify({"comment":comment}),
        method: 'POST',
        success: function(data) {
        	add_new_comment(data)
        },
        error: function(e) {
        }, 
    });
}

function add_new_comment(comment){
	
	if($('#comments_list').hasClass('comments-list') == false){
		console.log('tem classe')
		$('#comments_list').html('')
		$('#comments_list').addClass('comments-list')
	}
	
	$('#comments_list').append('\
			<li>\
			<div class="comment-main-level">\
				<div class="comment-avatar">\
					<img src="/uploads/user/'+comment.user.photoImageName+'"\
						alt="">\
				</div>\
				<div class="comment-box">\
					<div class="comment-head">\
						<h6 class="comment-name">'+comment.user.name+'</h6>\
						<span class="posted-time"><fmt:formatDate\
								value="" pattern="dd/MM/yyyy" /></span>\
					</div>\
					<div class="comment-content">'+comment.comment+'</div>\
				</div>\
			</div>\
		</li>')
		
	$("#text_comment").val('')
}


