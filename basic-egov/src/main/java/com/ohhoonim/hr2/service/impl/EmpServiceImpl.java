package com.ohhoonim.hr2.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.Emp2Dao;
import com.ohhoonim.hr2.service.EmpService;
import com.ohhoonim.vo.EmpVo;

@Service("emp2Service")
public class EmpServiceImpl implements EmpService{
	
	@Resource(name="emp2Dao")
	Emp2Dao empDao;

	@Override
	public List<EmpVo> empList(EmpVo vo) {
		List<EmpVo> empList = empDao.empList(vo);
		return empList;
	}

	@Override
	public Map<String,Object> empDetail(EmpVo vo) {
		
		Map<String,Object> empvo = empDao.empDetail(vo);
		
		return empvo;
	}

	@Override
	public int empAdd(EmpVo vo) {
		
		int empAdd = empDao.empAdd(vo);
		
		return empAdd;
	}

	@Override
	public int empRemove(EmpVo vo) {
		return empDao.empRemove(vo);
	}

	@Override
	public int empModify(EmpVo vo) {
		return empDao.empModify(vo);
	}

	@Override
	public List<EmpVo> deptEmpList(EmpVo vo) {
		return empDao.deptEmpList(vo);
	}

}
