package com.freedom.springsix.bean.factory;

import com.freedom.springsix.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @since 2023/9/29 12:47
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
