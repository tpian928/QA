package com.freeplay.qa.daolmpl;

import java.util.List;

import com.freeplay.qa.dao.UserDAO;
import com.freeplay.qa.pojo.User;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport; 

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{  
    //增加用户  
    public void saveUser(User user){  
        this.getHibernateTemplate().save(user);  
    }  
      
    //查询验证用户是否存在  
    public User findUser(User user){  
        User firstuser = new User();  
        //HQL查询语句  
        String hql = "from User user where user.username='"  
                + user.getUsername() + "' and user.password= '"  
                + user.getPassword() + "'";  
        
        //将查询出的结果放到List  
        List<User> userlist = (List<User>) this.getHibernateTemplate().find(hql);  
        //判断是否有查询结果，换句话说就是判断用户是否存在  
        if(userlist.size()>0){  
        //取出查询结果的第一个值，理论上数据库是没有重复的用户信息  
        firstuser = userlist.get(0);  
        }  
        return firstuser;  
    }
} 
