var q_id;

$(document).ready(function() {

	q_id = getUrlParameter("qid");
	o("q_id is "+q_id);

	get_question(q_id,function (data) {
		//o(data);
		var qtitle = data.qtitle;	
		o("qcontent is "+qcontent);
		$('#qtitle').text(qtitle);
		$('#qcontent').text(data.qcontent);
	});

	get_answer(q_id,function (data) {
		o(data);
		
		var result_html  = "";
		var answers = [];
		
		if(data.answer.length == undefined) {
			o("haha");
			answers.push(data.answer);
		}
		else {
			for(var i = 0; i < data.answer.length; i++) {
				answers.push(data.answer[i]);
			}
		}

		$.each(answers, function(index, item) {

			//o("item.acontent is "+item.acontent);
			var meta_html = $('#unit_html').html();
			meta_html = meta_html.replace("$$aid", item.aid);
			meta_html = meta_html.replace("$$aid", item.aid);
			meta_html = meta_html.replace("$$uid", item.uid);
			meta_html = meta_html.replace("$$username", item.uid);
			meta_html = meta_html.replace("$$acontent", item.acontent);
			meta_html = meta_html.replace("$$atime", item.atime);
			meta_html = meta_html.replace("$$count", item.alike);

			//o("meta_html "+meta_html);	

			result_html = result_html+meta_html;

		});		

		$("#dynamic_html").append(result_html);
	});

	
	$('#username').text(localStorage.uid);
});


$(document).on('click', ".agreeBtn", function() {
    o("agreeBtn");

    var aid = this.id

    if (isEmpty(aid)==false&&aid!=undefined) {

    	agree(aid,function (data) {

    		var result = parseInt(data.result)
    		if (result==0) {
    			o("result is 0");
    			window.location.reload();
    		}
    		else if (result==-2) {
				window.location.href="/QA/login.html";
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

$(document).on('click', ".disagreeBtn", function() {
    o("disagreeBtn");

    var aid = this.id

    if (isEmpty(aid)==false&&aid!=undefined) {

    	disagree(aid,function (data) {

    		var result = parseInt(data.result)
    		if (result==0) {
    			o("result is 0");
    			window.location.reload();
    		}
    		else if (result==-2) {
				window.location.href="/QA/login.html";
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









