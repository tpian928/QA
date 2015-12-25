var q_id;

$(document).ready(function() {

	q_id = getUrlParameter("q_id");
	o("q_id is "+q_id);

	get_question(q_id,function (data) {
		//o(data);
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