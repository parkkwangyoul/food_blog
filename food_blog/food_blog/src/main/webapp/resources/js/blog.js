if (typeof food.blog == 'undefined') {
		food.blog = {};
}

$(function() {
	food.blog.sync();
});

food.blog.sync = function(){
	$('#my_blog_go').unbind('click');
	$('#my_blog_go').bind('click', function(){
		food.blog.my_blog_go();
	});
};

food.blog.my_blog_go = function(){
	var blogAddress = $('#my_blog_go_wrap').attr('data-address');
	
	location.href= contextPath + 'blog/' + blogAddress + '/';
};