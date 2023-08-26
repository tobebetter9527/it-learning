package com.boge.test;

import com.boge.pojo.User;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import javax.sql.DataSource;

public class Mydemo {

    public static void main(String[] args) {
        PropertyTokenizer tokenizer = new PropertyTokenizer("orders[0].items[0].name");
        String name = tokenizer.getName();
        DataSource []

    }


}


