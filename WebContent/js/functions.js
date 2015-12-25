//调试用函数
function x (str) {
   document.write(str+"<br>");
}

//给ID的赋innerHTML
function idIsValue(id,value){
   var element = document.getElementById(id);
   element.innerHTML=value;
}

//调试输出
function o (str) {
	console.log(str);
}


function isEmpty (str) {
	if (str!=""&&str!=null&&str!="undefine") {
		return false;
	}
	else{
		return true;
	}

}

function a (str) {
	alert(str);
}

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};





