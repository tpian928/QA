package com.freeplay.qa.source;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.freeplay.qa.dao.UserDao;
import com.freeplay.qa.pojo.User;

@Path("test")
public class HelloResource {
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
    	
    	//UserDao.insert("haha", "sdsd");
    	
        return "Hello Fuck";
    }
}
