package com.ohhoonim.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.EmpVo;

@Repository("emp2Dao")
public class Emp2Dao extends Mapper {

	public List<EmpVo> empList(EmpVo vo) {
		return selectList("Emp2.empList", vo);
	}

	public Map<String,Object> empDetail(EmpVo vo) {
		return selectOne("Emp2.empDetail",vo);
	}

	public int empAdd(EmpVo vo) {
		return insert("Emp2.empAdd",vo);
	}

	public int empRemove(EmpVo vo) {
		return delete("Emp2.empRemove",vo);
	}

	public int empModify(EmpVo vo) {
		return update("Emp2.empModify",vo);
	}

	public List<EmpVo> deptEmpList(EmpVo vo) {
		return selectList("Emp2.deptEmpList",vo);
	}

}
