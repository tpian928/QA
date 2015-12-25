$('#askBtn').on('click', function () {
    o("askBtn");

    var q_title = $('#q_title').val();
    var q_desc = $('#q_desc').val();
    var uid = localStorage.uid;

    if (isEmpty(q_title)==false&&isEmpty(q_desc)==false&&isEmpty(uid)==false) {

    	ask(q_title,q_desc,uid,function (data) {

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
