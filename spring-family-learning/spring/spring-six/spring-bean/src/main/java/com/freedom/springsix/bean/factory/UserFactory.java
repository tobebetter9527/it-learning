package com.freedom.springsix.bean.factory;

import com.freedom.springsix.ioc.overview.domain.User;

public interface UserFactory {
    default User createUser(){
        return User.createUser();
    }

}
