if (typeof food.blog == 'undefined') {
		food.blog = {};
}

function isNull(obj) {
	if (obj == null || obj == undefined || obj == '' || obj == 'undefined') {
		return true;
	}
	return false;
}

var $editor;

$(function() {
	food.blog.sync();
	
	$editor = food.blog.board.start();
});

food.blog.sync = function(){
	$('#my_blog_go').unbind('click');
	$('#my_blog_go').bind('click', function(){
		food.blog.my_blog_go();
	});
	
	$('.blog_comment_add').unbind('click');
	$('.blog_comment_add').bind('click', function(){
		food.blog.commentAdd($(this));
	});
};

food.blog.my_blog_go = function(){
	var blogAddress = $('#my_blog_go_wrap').attr('data-address');
	
	location.href= contextPath + 'blog/' + blogAddress + '/';
};

food.blog.board = {
	start : function() {
		// ~ Not User Insert form
		this.deleted();
		// ~ Use Insert Form
		if (isNull($('#isWriteBoard').html())) {
			return;
		}
		this.submit();
		this.cancle();

		var editor = new cheditor();
		editor.config.editorHeight = '400px';
		editor.config.editorWidth = '600px';
		editor.inputForm = 'writeBoard';
		editor.run();
		return editor;
	},
	submit : function() {
		$('#board_confirm_btn').bind('click', function() {
			var form = document.forms['content'];
			form.content.value = $editor.outputBodyHTML();
			form.submit();
		});
	},
	cancle : function() {
		$('#board_cancel_btn').bind('click', function() {
			history.back();
		});
	},
	deleted : function() {
		$('#board_delete_btn').bind('click', function() {
			if (confirm("Are you sure you want delete content?")) {
				$("#content").submit();
			}
		});
	}
};

food.blog.commentAdd = function(target){
	var parent = target.parents().parents().parents().parents('.blog_content');
	var seq = parent.attr('data-pn');
	var content = target.parents('ul').children('.blog_comment_add_input_li').children('.blog_comment_input_input').val();
	var writeUser = parent.attr('data-user');
	
	var url = contextPath + '/blog/comment';
	var json = {
			'blogPn' : seq,
			'content' : content,
			'writeUser' : writeUser
	};
	
	$.postJSON(url, json, function(comment){
		return jQuery.ajax({
			success : function(){
				var commentWrap = target.parents().parents().parents().parents().children('.blog_content_comment');
				var html = '<ul>' +
								'<li class="name">' + comment.writeUser + '</li>' +
								'<li>' + comment.content + '</li>'+
								'<li class="date">' + comment.writeDate + '</li>' +
							'</ul>';
				commentWrap.append(html);
			},
			error : function(){
				error('댓글 작성중 에러발생!');
			}
		});
	});
};
