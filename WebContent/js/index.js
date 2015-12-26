$(document).ready(function() {

	get_all_ask(function (data) {
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

			//o("item.acontent is "+item.acontent);
			var meta_html = $('#unit_html').html();

			meta_html = meta_html.replace("$$qid", item.qid);
			meta_html = meta_html.replace("$$qtitle", item.qtitle);
			meta_html = meta_html.replace("$$qcontent", item.qcontent);
			

			// o("meta_html "+meta_html);	

			result_html = result_html+meta_html;

		});		

		$("#dynamic_html").append(result_html);
	});
	
	$('#username').text(localStorage.uid);

});



$('#username').on('click', function () {
	o("askBtn");
    window.location.href="/QA/user_question.html?uid="+localStorage.uid;
    
});

$('#askBtn').on('click', function () {
	o("askBtn");
    window.location.href="/QA/ask.html";
    
});


