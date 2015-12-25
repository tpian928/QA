$('#loginBtn').on('click', function () {
    o("clickedsdsd");

    var email = $('#email').val();
    var pw1 = $('#password').val();

    if (isEmpty(email)==false&&isEmpty(pw1)==false) {

    	login(email,pw1,function (data) {
    		var result = parseInt(data.result)
    		if (result==0) {
    			window.location.href="/index.html";
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