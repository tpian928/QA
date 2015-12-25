var uid;
var meta_html;

$(document).ready(function() {

	uid = getUrlParameter("uid");
	

	get_user_answer(uid,function (data) {
		// o(data);
		
		var result_html  = "";
		var answers = [];
		
		if(data.answer.length == undefined) {
			answers.push(data.answer);
		}
		else {
			for(var i = 0; i < data.answer.length; i++) {
				answers.push(data.answer[i]);
			}
		}

	answers.forEach(function(item){		
			get_question(item.qid,function (data2) {
				o("data2 is "+data2);
				var meta_html = $('#unit_html').clone().html();
				
				//o(meta_html);
				 meta_html = meta_html.replace("$$qtitle", data2.qtitle);
				 meta_html = meta_html.replace("$$qcontent", data2.qcontent);
				 meta_html = meta_html.replace("$$acontent", item.acontent);
				 meta_html = meta_html.replace("$$qid", item.qid);
					$("#dynamic_html").append(meta_html);

			});
			
			o("item.acontent is "+item.acontent);

		});


		$("#dynamic_html").append(result_html);
	});

	$('#username').text(localStorage.uid);

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