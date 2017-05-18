package com.mlds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017年04月25日 17:18
 */
@RestController
public class TestDemo {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public Object  hello(HttpSession session) throws Exception {
        Object o=session.getAttribute("uid");
        return o;
    }
}
