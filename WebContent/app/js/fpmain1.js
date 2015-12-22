$(document).ready(function(){
	for(var i = 0; i < 1; i++) {
		var $tpl = $("#test");
		var source = $tpl.text();
		var template = Handlebars.compile(source);
		
		var data = {		
		user: 'David',
        title: '怎么看待“在辩论会上，反对派工党引用毛泽东语录，反驳保守党”?',
        description: '话说...事情是这样的....昨天周三，又到了英国国会例行的辩论时间....昨天交锋的，是反对党工党的影子财政大臣John McDonnell，和现在执政的保守党的财政大臣奥斯本他们讨论的话题嘛....  就是前段时间英国接受中国的400多亿的投资的问题...'
		
		};
		
		
		
		var html = template(data);
		console.log(html);
		$("#fp-main-container").append($(html));
	}
});