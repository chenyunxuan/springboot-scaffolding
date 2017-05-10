package com.mlds.entity;

import com.mlds.core.dao.DataSource1Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017-05-05 11:38
 */
@Configuration
@MapperScan(basePackages = "com.mlds.dao.test1", sqlSessionTemplateRef  = "test1SqlSessionTemplate")
public class BaseDataSourceConfig extends DataSource1Config {
}
