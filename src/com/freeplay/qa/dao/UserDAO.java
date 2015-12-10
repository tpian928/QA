package com.freeplay.qa.dao;

import java.util.List;  

import com.freeplay.qa.pojo.User;


  
public interface UserDAO {  
    //声明增加和查找方法  
    public void saveUser(User user);  
      
    public User findUser(User user);  
}
