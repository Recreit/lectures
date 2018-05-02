package com.ohhoonim.hr2.service;

import java.util.List;
import java.util.Map;

import com.ohhoonim.vo.EmpVo;

public interface EmpService {

	List<EmpVo> empList(EmpVo vo);

	Map<String,Object> empDetail(EmpVo vo);

	int empAdd(EmpVo vo);

	int empRemove(EmpVo vo);

	int empModify(EmpVo vo);

	List<EmpVo> deptEmpList(EmpVo vo);


	
}
