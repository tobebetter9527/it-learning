package com.dsa;

import java.util.Date;

public class MyDemo {
    public static void main(String[] args) {
        Date date = new Date();
        int i = date.compareTo(new Date());
        System.out.println(i);

    }
}
