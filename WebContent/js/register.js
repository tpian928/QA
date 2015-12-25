$('#registerBtn').on('click', function () {
    o("clickedsdsd");

    var email = $('#email').val();
    var pw1 = $('#pw1').val();
    var pw2 = $('#pw2').val();

    if (pw1==pw2&&isEmpty(email)==false&&isEmpty(pw1)==false) {

    	register(email,pw1,function (data) {
    		var result = parseInt(data.result)
    		if (result==0) {
                localStorage.uid = data.uid;
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
