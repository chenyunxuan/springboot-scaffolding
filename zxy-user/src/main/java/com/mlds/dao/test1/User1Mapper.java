package com.mlds.dao.test1;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface User1Mapper {

	List<HashMap> getAll();

	Map getOne(String id);

	void insert(Map user);

	void update(Map user);

	void delete(String id);

}