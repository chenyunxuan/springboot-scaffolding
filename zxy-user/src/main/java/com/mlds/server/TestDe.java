package com.mlds.server;

import com.mlds.dao.test1.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017年04月25日 17:18
 */
@Service
public class TestDe {
    @Autowired
    private User1Mapper user1Mapper;

    public Object pageDemo(Integer pageNum,Integer pageSize,String demo) {
        List<HashMap> mapList=user1Mapper.getAll();
        for(HashMap m:mapList){
            m.put("aaaaaa",demo);
        }
        return mapList;
    }
}
