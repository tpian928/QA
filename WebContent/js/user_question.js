var uid;

$(document).ready(function() {

	uid = getUrlParameter("uid");
	o("uid is "+uid);

	// get_user_question(uid,function (data) {
	// 	o(data);
	// 	// var qtitle = data.qtitle;	
	// 	// o("qcontent is "+qcontent);
	// 	// $('#qtitle').text(qtitle);
	// 	// $('#qcontent').text(data.qcontent);
	// });

	get_user_question(uid,function (data) {
		o(data);
		var result_html  = "";
		var questions = [];

		if(data.question.length == undefined) {
			o("haha");
			questions.push(data.question);
		}
		else {
			for(var i = 0; i < data.question.length; i++) {
				questions.push(data.question[i]);
			}
		}
		
		$.each(questions, function(index, item) {

			var meta_html = $('#unit_html').html();
			
			meta_html = meta_html.replace("$$qtitle", item.qtitle);
			meta_html = meta_html.replace("$$qcontent", item.qcontent);

			result_html = result_html+meta_html;

		});		

		$("#dynamic_html").append(result_html);
	});

	

});

