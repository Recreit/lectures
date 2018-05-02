package com.ohhoonim.hr2.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohhoonim.hr2.service.DeptService;
import com.ohhoonim.vo.DeptVo;

@Controller("dept2Controller")
public class DeptController {
	
	@Resource(name="dept2Service")
	DeptService deptService;

}
	
	

