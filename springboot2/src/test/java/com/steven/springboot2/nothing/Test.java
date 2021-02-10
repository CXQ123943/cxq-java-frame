package com.steven.springboot2.nothing;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author CXQ
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }
}
