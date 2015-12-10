package com.freeplay.qa.serviceimpl;

import com.freeplay.qa.dao.UserDAO;
import com.freeplay.qa.pojo.User;
import com.freeplay.qa.service.UserService;

  
public class UserServiceImpl implements UserService{  
    //注入DAO，生成GET SET 方法  
    private UserDAO userdao;  
  
    public UserDAO getUserdao() {  
        return userdao;  
    }  
  
    public void setUserdao(UserDAO userdao) {  
        this.userdao = userdao;  
    }  
  
    //保存用户信息  
    public void saveUser(User user){  
        this.userdao.saveUser(user);  
    }
    
    //查找验证用户信息  
    public boolean findUser(User user){  
        //  
        User firstuser = this.userdao.findUser(user);  
        //在UserDAO查询中已经判断了只有当用户名和密码都存在时才返回firstuser  
        //所以在这里只用判断firstuser里面用户名或者密码中的一个是否存在就可以了  
        if(firstuser.getUsername()!=null){  
            return true;  
        }else{  
            return false;  
        }  
    }
    
}  
