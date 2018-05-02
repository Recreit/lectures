package com.ohhoonim.test.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ohhoonim.dao.Emp2Dao;
import com.ohhoonim.vo.EmpVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:**/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional(value = "txManager")
public class Emp2DaoTest {
	@Resource(name="emp2Dao")
	Emp2Dao dao;
	
	@Test
	public void empAddTest() {
		int resultCnt = empAdd();
		assertThat(resultCnt, is(1));
	}
	
	private int empAdd() {
		EmpVo vo = new EmpVo();
		vo.setEmpno("4577");
		vo.setEname("우우우");
		vo.setSal("1200");
		vo.setAge("13");
		vo.setDeptno("10");
		vo.setHiredate("2011-11-23");
		vo.setComm("");
		vo.setManager("");
		
		return dao.empAdd(vo);
	}
	
	@Test
	public void empListTest() {
		empAdd();
		List<EmpVo> empList = dao.empList(new EmpVo());
		assertThat(empList.size() > 0, is(true));
	}
	
	@Test
	public void empDetailTest() {
		empAdd();
		
		EmpVo vo = new EmpVo();
		vo.setEmpno("4577");
		Map<String,Object> resultMap = dao.empDetail(vo);
		assertThat((String)resultMap.get("ename"), is("우우우"));
	}
	
	@Test
	public void empRemoveTest() {
		empAdd();
		
		EmpVo vo = new EmpVo();
		vo.setEmpno("4577");
		int resultCnt = dao.empRemove(vo);
		assertThat(resultCnt > 0 , is(true));
	}
	
	@Test
	public void empModifyTest() {
		empAdd();
		
		EmpVo vo = new EmpVo();
		vo.setEmpno("4577");
		vo.setEname("우우우");
		vo.setSal("1220");
		vo.setAge("13");
		vo.setDeptno("10");
		vo.setHiredate("2011-11-23");
		vo.setComm("");
		vo.setManager("");
		int resultCnt = dao.empModify(vo);
		assertThat(resultCnt == 1 , is(true));
	}
	
	@Test
	public void deptEmpListTest() {
		empAdd();
		EmpVo vo = new EmpVo();
		vo.setDeptno("10");
		List<EmpVo> empList = dao.deptEmpList(vo);
		assertThat(empList.size() > 0, is(true));
	}
}
