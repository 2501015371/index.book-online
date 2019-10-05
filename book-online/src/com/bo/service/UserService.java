package com.bo.service;


import com.bo.entity.User;
import com.bo.utils.Md5Util;

import java.util.List;

public class UserService {
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    public User sigIn(String account, String passsword){
        for (User user : userList){
            if (user.getAccount().equals(account)&&user.getPassword().equals(Md5Util.crypt(passsword))){
                return user;
            }
        }
        return null;
    }
}
