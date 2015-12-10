package com.freeplay.qa.action;

import com.freeplay.qa.pojo.User;
import com.freeplay.qa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport{  
    private User user;  
    
    //注入Service,生成SET GET方法  
    private UserService userservice;  
    
    public User getUser() {  
        return user;  
    }  
    public void setUser(User user) {  
        this.user = user;  
    }  
    public UserService getUserservice() {  
        return userservice;  
    }  
    public void setUserservice(UserService userservice) {  
        this.userservice = userservice;  
    }  
      
    //execute方法  
    @Override  
    public String execute() throws Exception {  
        this.userservice.saveUser(this.user);  
        return SUCCESS;  
    }  
  
}  
