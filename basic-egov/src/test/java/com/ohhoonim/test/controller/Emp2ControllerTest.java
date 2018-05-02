package com.ohhoonim.test.controller;


import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ohhoonim.hr2.service.DeptService;
import com.ohhoonim.hr2.service.EmpService;
import com.ohhoonim.hr2.web.EmpController;
import com.ohhoonim.vo.EmpVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:**/applicationContext.xml")
@WebAppConfiguration
public class Emp2ControllerTest {
	@InjectMocks private EmpController controller = new EmpController();
	@Mock EmpService empService;
	@Mock DeptService deptService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	//controller의 역할 
	// 1. url을 캐치하여 메소드가 실행되게 한다.
	// 2. 넘어온 파라미터를 받는다.
	// 3. 비지니스 로직이 필요한 경우 service를 호출한다.
	// 4. view(jsp or url)에 넘겨줄 값을 세팅
	// 5. view(jsp or url)를 호출
	
	@Test
	public void empListTest() throws Exception {
		mockMvc.perform(post("/hr2/empList.do"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("empList"))
			.andExpect(view().name("hr2/empList"))
		;
				
	}
	
	@Test
	public void empDetailTest() throws Exception {
		mockMvc.perform(post("/hr2/empDetail.do"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("empvo"))
			.andExpect(view().name("hr2/empDetail"))
		;
	}
	
	@Test
	public void empAddViewTest() throws Exception {
		mockMvc.perform(post("/hr2/empAddView.do"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("empList"))
			.andExpect(model().attributeExists("deptList"))
			.andExpect(view().name("hr2/empAdd"))
		;
	}
	
	@Test
	public void empAdd1Test() throws Exception {
		mockMvc.perform(post("/hr2/empAdd.do"))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/hr2/empAddView.do"))
		;
	}
	
	@Test
	public void empAdd2Test() throws Exception {
		
		when(empService.empAdd((EmpVo)anyObject())).thenReturn(1);
		
		mockMvc.perform(post("/hr2/empAdd.do"))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/hr2/empList.do"))
		;
	}
	
	@Test
	public void empRemoveTest() throws Exception {
		
		when(empService.empRemove((EmpVo)anyObject())).thenReturn(1);
		
		mockMvc.perform(post("/hr2/empRemove.do"))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/hr2/empList.do"))
		;
	}
	
	@Test
	public void empRemove2Test() throws Exception {
		
		String empno = "1223";
		
		mockMvc.perform(post("/hr2/empRemove.do").param("empno",empno))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/hr2/empDetail.do?empno="+empno))
		;
	}
	
	@Test
	public void empModifyViewTest() throws Exception {
		mockMvc.perform(post("/hr2/empModifyView.do"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("empvo","empList","deptList"))
			.andExpect(view().name("hr2/empModify"))
		;
	}
	
	@Test
	public void empModify1Test() throws Exception {
		String empno = "9999";
		
		when(empService.empModify((EmpVo)anyObject())).thenReturn(1);
		
		mockMvc.perform(post("/hr2/empModify.do").param("empno",empno))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/hr2/empDetail.do?empno="+empno))
		;
	}
	
	@Test
	public void empModify2Test() throws Exception {
		String empno = "9999";
		mockMvc.perform(post("/hr2/empModify.do").param("empno",empno))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/hr2/empModifyView.do?empno="+empno))
		;
	}
	
	@Test
	public void checkDupEmpTest() throws Exception {
		Map<String,Object> rtnMap = new HashMap<String,Object>();
		when(empService.empDetail((EmpVo)anyObject())).thenReturn(rtnMap);
		
		mockMvc.perform(post("/hr2/checkDupEmp.do"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.isDup").value(true))
		;
	}
	
	@Test
	public void deptEmpListTest() throws Exception {
		
		when(empService.deptEmpList((EmpVo)anyObject())).thenAnswer(new Answer<List<EmpVo>>() {

			@Override
			public List<EmpVo> answer(InvocationOnMock invocation) throws Throwable {
				List<EmpVo> list = new ArrayList<EmpVo>();
				
				EmpVo vo1 = new EmpVo();
				vo1.setEmpno("kim");
				
				EmpVo vo2 = new EmpVo();
				vo1.setEmpno("lee");
				
				EmpVo vo3 = new EmpVo();
				vo1.setEmpno("park");
				
				list.add(vo1);
				list.add(vo2);
				list.add(vo3);
				
				return list;
			}
			
		});
		
		mockMvc.perform(post("/hr2/deptEmpList.do"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.deptEmpList").value(true))
		;
	}
	
}
