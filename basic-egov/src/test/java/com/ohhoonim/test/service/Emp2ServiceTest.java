package com.ohhoonim.test.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.ohhoonim.dao.Emp2Dao;
import com.ohhoonim.hr2.service.EmpService;
import com.ohhoonim.hr2.service.impl.EmpServiceImpl;
import com.ohhoonim.vo.EmpVo;

@RunWith(MockitoJUnitRunner.class)
public class Emp2ServiceTest {
	
	@InjectMocks
	private EmpService service = new EmpServiceImpl();
	
	@Mock
	Emp2Dao empDao;
	
	@Test
	public void empListTest() {
		when(empDao.empList((EmpVo)anyObject())).thenAnswer(new Answer<List<EmpVo>>() {

				@Override
				public List<EmpVo> answer(InvocationOnMock invocation) throws Throwable {
					List<EmpVo> empList = new ArrayList<EmpVo>();
					EmpVo vo = new EmpVo();
					vo.setEmpno("1233");
					
					empList.add(vo);
					
					return empList;
				}
			});
		
		List<EmpVo> resultList = service.empList(new EmpVo());
		assertThat(resultList.get(0).getEmpno(), is("1233"));
		
	}
	
	@Test
	public void empDetailTest() {
		when(empDao.empDetail((EmpVo)anyObject())).thenAnswer(new Answer<Map<String, Object>>(){

			@Override
			public Map<String, Object> answer(InvocationOnMock invocation) throws Throwable {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("empno", "1234");
				return map;
			}
			
		});
		
		Map<String,Object> resultMap = service.empDetail(new EmpVo());
		assertThat((String)resultMap.get("empno"), is("1234"));
		
	}

	
}
