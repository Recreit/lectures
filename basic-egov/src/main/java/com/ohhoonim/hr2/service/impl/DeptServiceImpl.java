package com.ohhoonim.hr2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.Dept2Dao;
import com.ohhoonim.hr2.service.DeptService;
import com.ohhoonim.vo.DeptVo;

@Service("dept2Service")
public class DeptServiceImpl implements DeptService{
	
	@Resource(name="dept2Dao")
	Dept2Dao deptDao;

	@Override
	public List<DeptVo> deptList(DeptVo deptvo) {
		return deptDao.deptList(deptvo);
	}
}
