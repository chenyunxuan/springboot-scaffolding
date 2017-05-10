package com.mlds.controller;

import com.mlds.server.TestDe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017年04月25日 17:18
 */
@RestController
public class TestDemo {

    @RequestMapping(value = "hello/{a}", method = RequestMethod.GET)
    public String  hello(@PathVariable Integer a) throws Exception {
        TestDe de=null;
        if(a==1){
            de=new TestDe();
        }
        return null;
    }
}
