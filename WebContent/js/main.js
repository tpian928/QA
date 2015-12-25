/*
 * Base Operations
 * Author: Fengdalu
 */

//settings
var settings = {
	HOST : "http://localhost",
	PORT : "8080",
	APP : "/QA/api",
	getURL : function() {
		return this.HOST + ":" + this.PORT + this.APP;
	}
};

// register
var register = function(uname, pw, callback) {
	$.ajax({
		type : 'POST',
		url : settings.getURL() + "/user/register",
		data : {
			uname : uname,
			pw : pw
		},
		dataType : "json",
		success : callback
	});
};

// login
var login = function(uname, pw, callback) {
	$.ajax({
		type : 'POST',
		url : settings.getURL() + "/user/login",
		data : {
			uname : uname,
			pw : pw
		},
		dataType : "json",
		success : callback
	});
};

// logout
var logout = function(callback) {
	$.ajax({
		type : 'POST',
		url : settings.getURL() + "/user/logout",
		data : {},
		dataType : "json",
		success : callback
	});
};

// ask a question
var ask = function(title, desc, uid, callback) {
	$.ajax({
		type : 'POST',
		url : settings.getURL() + "/qa/ask",
		data : {
			title : title,
			desc : desc,
			uid : uid
		},
		dataType : "json",
		success : callback
	});
};

// answer a question
var answer = function(acontent, uid, qid, callback) {
	$.ajax({
		type : "POST",
		url : settings.getURL() + "/qa/answer",
		dataType : "json",
		data : {
			acontent : acontent,
			uid : uid,
			qid : qid
		},
		success : callback
	});
}

// Zan
// CAN NOT USE
var zan = function(aid, callback) {
	$.ajax({
		type : "POST",
		url : settings.getURL() + "/qa/zan",
		dataType : "json",
		data : {
			aid : aid
		},
		success : callback
	});
}

var get_question = function (qid,callback) {
	$.ajax({
		type : "GET",
		url : settings.getURL() + "/qa/ask/"+qid,
		dataType : "json",
		data : {

		},
		success : callback
	});	
}

var get_answer = function (qid,callback) {
	$.ajax({
		type : "GET",
		url : settings.getURL() + "/qa/answer/"+qid,
		dataType : "json",
		data : {

		},
		success : callback
	});	
}

var get_user_question = function (uid,callback) {
	$.ajax({
		type : "GET",
		url : settings.getURL() + "/qa/user_ask/"+uid,
		dataType : "json",
		data : {

		},
		success : callback
	});	
}

var get_user_answer = function (uid,callback) {
	$.ajax({
		type : "GET",
		url : settings.getURL() + "/qa/user_answer/"+uid,
		dataType : "json",
		data : {

		},
		success : callback
	});	
}

// user_ask

$(document).ready(function() {

});