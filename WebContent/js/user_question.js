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
		
		$.each(data.question, function(index, item) {

			var meta_html = $('#unit_html').html();
			
			meta_html = meta_html.replace("$$qtitle", item.qtitle);
			meta_html = meta_html.replace("$$qcontent", item.qcontent);

			result_html = result_html+meta_html;

		});		

		$("#dynamic_html").append(result_html);
	});

	

});

$('#answerBtn').on('click', function () {
    o("answerBtn");

    var answer_content = $('#answer_text').val();
    var uid = localStorage.uid;

    if (isEmpty(answer_content)==false&&isEmpty(uid)==false) {

        var uid = localStorage.uid;
		o("q_id here is "+q_id);

    	answer(answer_content,uid,q_id,function (data) {

    		var result = parseInt(data.result)
    		if (result==0) {
    			window.location.href="/QA/index.html";
    		}
    		else{
    			alert("错误");
    		}

    	});

    }
    else{
    	alert("错误的填写");
    }



});