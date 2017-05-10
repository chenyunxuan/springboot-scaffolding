package com.mlds.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface User2Mapper {
	
	List<HashMap> getAll();
	
	Map getOne(Long id);

	void insert(Map user);

	void update(Map user);

	void delete(Long id);

}