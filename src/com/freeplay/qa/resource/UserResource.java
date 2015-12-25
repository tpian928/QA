package com.freeplay.qa.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.freeplay.qa.dao.AnswerDao;
import com.freeplay.qa.dao.QuestionDao;
import com.freeplay.qa.dao.UserDao;
import com.freeplay.qa.response.Result;
import com.freeplay.qa.response.UserResponse;

/**
 * UserResource
 * 
 * @author Fengdalu
 */
@Path("/user")
public class UserResource {
	/**
	 * Register
	 * 
	 * @param request
	 */
	@POST
	@Path("register")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserResponse register(@FormParam("uname") String username,
			@FormParam("pw") String password,
			@Context HttpServletRequest request) {
		System.out.println(username + " " + password);
		UserResponse userResponse = new UserResponse();
		/*
		 * check if exist
		 */
		if (UserDao.getUser(username) != null) {
		//if(false){
			userResponse.setResult(Result.FAIL.toString());
		} else {
			UserDao.insert(username, password);

			int uid = UserDao.getUser(username).getUid();
			userResponse.setResult(Result.SUCCESS.toString());
			userResponse.setUid(String.valueOf(uid));
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("login", "yes");
		return userResponse;
	}

	/**
	 * Login
	 * 
	 * @param request
	 */
	@POST
	@Path("login")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserResponse login(@FormParam("uname") String username,
			@FormParam("pw") String password,
			@Context HttpServletRequest request) {
		UserResponse userResponse = new UserResponse();

		if (!UserDao.check(username, password)) {
			userResponse.setResult(Result.FAIL.toString());
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("login", "yes");
			int uid = UserDao.getUser(username).getUid();
			userResponse.setResult(Result.SUCCESS.toString());
			userResponse.setUid(String.valueOf(uid));
		}
		return userResponse;
	}

	/**
	 * Logout
	 * 
	 * @param request
	 */
	@POST
	@Path("logout")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserResponse logout(@Context HttpServletRequest request) {

		UserResponse userResponse = new UserResponse();
		HttpSession session = request.getSession(true);
		String pw;

		if ((pw = (String) session.getAttribute("login")).equals("yes")) {
			session.setAttribute("login", "no");
			userResponse.setResult(Result.SUCCESS.toString());
		} else
			userResponse.setResult(Result.FAIL.toString());
		return userResponse;
	}
	
    @GET
	@Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
    	System.out.println("fuck");
        return "Hello Jersey";
    }

}
