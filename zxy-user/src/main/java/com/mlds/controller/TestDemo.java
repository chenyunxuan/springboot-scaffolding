package com.mlds.controller;

import com.mlds.server.TestDe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017年04月25日 17:18
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/user")
public class TestDemo {
    @Autowired
    private TestDe test;


    @GetMapping("/userInfo")
    @Cacheable(value="com.mlds")
    public Object hello(HttpSession session,@RequestParam Map<String, Object> map) throws Exception {
        Object o=test.pageDemo( Integer.parseInt(map.get("a").toString()), Integer.parseInt(map.get("b").toString()),"啊哈");
        session.setAttribute("uid", o);
        return o;
    }
}
