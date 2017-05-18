package com.mlds.server;

import com.mlds.dao.test1.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    public Object pageDemo(Integer pageNum,Integer pageSize,String demo) {
        List<HashMap> mapList=user1Mapper.getAll();
        stringRedisTemplate.opsForValue().set("aaa", mapList.toString());
        ValueOperations<String, Object> operations=redisTemplate.opsForValue();
        operations.set("com.mlds",mapList);
        return mapList;
    }
}
