package com.ohhoonim.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.DeptVo;

@Repository("dept2Dao")
public class Dept2Dao extends Mapper {

	public List<DeptVo> deptList(DeptVo deptvo) {
		return selectList("Dept2.deptList", deptvo);
	}


}
