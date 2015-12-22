$(document).ready(function(){
	for(var i = 0; i < 1; i++) {
		var $tpl = $("#test");
		var source = $tpl.text();
		var template = Handlebars.compile(source);
		
		var data = {		
		user: 'David',
        title: '如何看待国内体育类高校运动康复类专业自身定位不清的问题？',
        description: '题主是现体育学院运动康复在校学生目前感到困惑的是越来越感觉到学校对这个专业的定位非常不清晰我们虽然是运动康复专业但是我感觉这个专业 理论基础比不上运动人体科学的同学康复治疗实践能力比不上医学院校的康复治疗学学生骨科理论比不上中医院校的学生'
		
		};
		
		
		
		var html = template(data);
		console.log(html);
		$("#fp-main-container").append($(html));
	}
});