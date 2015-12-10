package com.freeplay.qa.service;

import com.freeplay.qa.pojo.User;

public interface UserService {  
    //声明增加和查找方法  
    public void saveUser(User user);  
      
    public boolean findUser(User user);  
}
