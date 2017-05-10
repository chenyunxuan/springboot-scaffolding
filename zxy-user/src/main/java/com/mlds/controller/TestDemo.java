package com.mlds.controller;

import com.mlds.server.TestDe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017年04月25日 17:18
 */
@RestController
@RequestMapping("/user")
public class TestDemo {
    @Autowired
    private TestDe test;

    @GetMapping("/userInfo")
    public Object hello(@RequestParam Map<String, Object> map) throws Exception {
        Object o=test.pageDemo( Integer.parseInt(map.get("a").toString()), Integer.parseInt(map.get("b").toString()),"啊哈");
        return o;
    }
}
