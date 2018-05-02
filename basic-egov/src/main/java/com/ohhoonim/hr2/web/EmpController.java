package com.ohhoonim.hr2.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohhoonim.hr2.service.DeptService;
import com.ohhoonim.hr2.service.EmpService;
import com.ohhoonim.vo.DeptVo;
import com.ohhoonim.vo.EmpVo;

@Controller("emp2Controller")
public class EmpController {
	
	@Resource(name="emp2Service")
	EmpService empService;
	
	@Resource(name="dept2Service")
	DeptService deptService;
	
	@RequestMapping("/hr2/empList.do")
	public String empList (@RequestParam Map<String,String> req, ModelMap model) {
		
		EmpVo vo = new EmpVo();
		
		List<EmpVo> list = empService.empList(vo);
		
		model.addAttribute("empList", list);
		
		return "hr2/empList";
	}
	
	@RequestMapping("/hr2/empDetail.do")
	public String empDetail(@RequestParam Map<String, String> req, ModelMap model) {
		String empno = req.get("empno");
		
		EmpVo vo = new EmpVo();
		vo.setEmpno(empno);
		
		Map<String,Object> empvo = empService.empDetail(vo);
		model.addAttribute("empvo",empvo);
		
		List<EmpVo> empList = empService.empList(new EmpVo());
		model.addAttribute("empList",empList);
		
		List<DeptVo> deptList = deptService.deptList(new DeptVo()); 
		model.addAttribute("deptList",deptList);
		
		return "hr2/empDetail";
	}
	
	@RequestMapping("/hr2/empAddView.do")
	public String empAddView(@RequestParam Map<String, String> req, ModelMap model) {
		
		List<EmpVo> empList = empService.empList(new EmpVo());
		
		DeptVo deptvo = new DeptVo();
		List<DeptVo> deptList = deptService.deptList(deptvo); 
		
		model.addAttribute("empList",empList);
		model.addAttribute("deptList",deptList);
		
		return "hr2/empAdd";
	}
	
	@RequestMapping("/hr2/empAdd.do")
	public String empAdd(@RequestParam Map<String, String> req, ModelMap model) {
		
		String rtnUrl = "redirect:/hr2/empList.do";
		
		EmpVo vo = new EmpVo();
		vo.setEmpno(req.get("empno"));
		vo.setEname(req.get("ename"));
		vo.setSal(req.get("sal"));
		vo.setManager(req.get("manager"));
		vo.setDeptno(req.get("deptno"));
		vo.setHiredate(req.get("hiredate"));
		vo.setAge(req.get("age"));
		vo.setComm(req.get("comm"));
		
		int resultCnt = empService.empAdd(vo);
		
		if (resultCnt < 1) {
			rtnUrl = "redirect:/hr2/empAddView.do";
		}
		
		return rtnUrl;
	}
	
	@RequestMapping("/hr2/empRemove.do")
	public String empRemove(@RequestParam Map<String, String> req, ModelMap model) {
		
		String rtnUrl = "redirect:/hr2/empList.do";
		
		EmpVo vo = new EmpVo();
		vo.setEmpno(req.get("empno"));
		
		int resultCnt = empService.empRemove(vo);
		
		if (resultCnt < 1) {
			rtnUrl = "redirect:/hr2/empDetail.do?empno="+ req.get("empno");
		}
		
		return rtnUrl;
	}
	
	@RequestMapping("/hr2/empModifyView.do")
	public String empModifyView(@RequestParam Map<String, String> req, ModelMap model) {
		String empno = req.get("empno");
		
		EmpVo vo = new EmpVo();
		vo.setEmpno(empno);
		
		Map<String,Object> empvo = empService.empDetail(vo);
		List<EmpVo> empList = empService.empList(new EmpVo());
		
		DeptVo deptvo = new DeptVo();
		List<DeptVo> deptList = deptService.deptList(deptvo); 
		
		model.addAttribute("empvo",empvo);
		model.addAttribute("empList",empList);
		model.addAttribute("deptList",deptList);
		
		return "hr2/empModify";
	}
	
	@RequestMapping("/hr2/empModify.do")
	public String empModify(@RequestParam Map<String, String> req, ModelMap model) {
		
		String rtnUrl = "redirect:/hr2/empDetail.do?empno="+ req.get("empno");
		
		EmpVo vo = new EmpVo();
		vo.setEmpno(req.get("empno"));
		vo.setEname(req.get("ename"));
		vo.setSal(req.get("sal"));
		vo.setManager(req.get("manager"));
		vo.setDeptno(req.get("deptno"));
		vo.setHiredate(req.get("hiredate"));
		vo.setAge(req.get("age"));
		vo.setComm(req.get("comm"));
		
		int resultCnt = empService.empModify(vo);
		
		if (resultCnt < 1) {
			rtnUrl = "redirect:/hr2/empModifyView.do?empno=" + req.get("empno");
		}
		
		return rtnUrl;
	}
	
	@RequestMapping("/hr2/testurl.do")
	public String testurl() {
		
		// 0. ""
		// 1. jsp
		// 2. redirect
		// 3. @ResponseBody
		
		return "redirect:/hr2/empList.do";
	}
	
	@RequestMapping("/hr2/ajaxCall.do")
	@ResponseBody
	public Object ajaxCall() {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		/*
		rtnMap.put("totalCnt", 23);
		
		EmpVo vo = new EmpVo();
		vo.setEmpno("1002");
		vo.setEname("kim");
		rtnMap.put("empVo", vo);
		
		List<String> bookList = new ArrayList<String>();
		bookList.add("book1");
		bookList.add("book2");
		bookList.add("book3");
		bookList.add("book4");
		rtnMap.put("books", bookList);
		*/
		
		List<EmpVo> empList = new ArrayList<EmpVo>();
		empList.add(new EmpVo("1002","kim","46"));
		empList.add(new EmpVo("1005","park","23"));
		empList.add(new EmpVo("1008","lee","51"));
		
		Map<String, List<EmpVo>> empList2 = new HashMap<String, List<EmpVo>>();
		
		empList2.put("list1", empList);
		
		List<EmpVo> list2 = new ArrayList<EmpVo>();
		list2.add(new EmpVo("2001","john","44"));
		list2.add(new EmpVo("2002","nam","33"));
		list2.add(new EmpVo("2003","hong","22"));
		
		empList2.put("list2", list2);
		
		List<EmpVo> list3 = new ArrayList<EmpVo>();
		list3.add(new EmpVo("3001","king","55"));
		
		empList2.put("list3", list3);
		
		rtnMap.put("empList", empList2);
		
		return rtnMap;
	}
	
	@RequestMapping("/hr2/checkDupEmp.do")
	@ResponseBody
	public Object checkDupEmp(@RequestParam Map<String, String> req) {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		String empno = req.get("empno");
		
		EmpVo vo = new EmpVo();
		vo.setEmpno(empno);
		
		Map<String,Object> empvo = empService.empDetail(vo);
		
		boolean checkDup = false;
		if ( empvo != null) {
			checkDup = true;
		}
		rtnMap.put("isDup", checkDup);
		
		return rtnMap;
	}
	
	@RequestMapping("/hr2/deptEmpList.do")
	@ResponseBody
	public Object deptEmpList(@RequestParam Map<String, String> req) {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		String deptno = req.get("deptno");
		
		EmpVo vo = new EmpVo();
		vo.setDeptno(deptno);
		List<EmpVo> deptEmpList = empService.deptEmpList(vo);
		
		rtnMap.put("deptEmpList", deptEmpList);
		
		return rtnMap;
	}
	
	
}
