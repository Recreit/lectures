package com.ohhoonim.ifRcv.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohhoonim.common.util.Utils;
import com.ohhoonim.ifRcv.service.NoticeService;
import com.ohhoonim.vo.NoticeVo;


@Controller("noticeController")
public class NoticeController {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(NoticeController.class);
	
	@Resource(name="noticeService")
	NoticeService noticeService;
	
	@RequestMapping("/ifRcv/noticeList.do")
	public String noticeList (@RequestParam Map<String,String> req, ModelMap model) {
		
		String noticeDate = Utils.toEmptyBlank(req.get("noticeDate"));
		
		List<NoticeVo> list = new ArrayList<NoticeVo>();
		if (!noticeDate.equals("")) {
			NoticeVo vo = new NoticeVo();
			vo.setNotice_date(noticeDate);
			list = noticeService.noticeList(vo);
		}
		
		model.addAttribute("noticeList",list);
		model.addAttribute("noticeDate",noticeDate);
		
		return "ifRcv/noticeList";
	}
	
}
