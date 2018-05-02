package com.ohhoonim.ifSend.web;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohhoonim.common.util.Utils;
import com.ohhoonim.ifSend.service.NoticeSendService;
import com.ohhoonim.vo.NoticeVo;


@Controller("noticeSendController")
public class NoticeController {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(NoticeController.class);
	
	@Resource(name="noticeSendService")
	NoticeSendService noticeService;
	
	@RequestMapping("/ifSend/noticeList.do")
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
		
		return "ifSend/noticeList";
	}
	
	@RequestMapping("/ifSend/sendNotice.do")
	public String sendNotice (@RequestParam Map<String,String> req, ModelMap model, RedirectAttributes ra) {
		
		String noticeDate = Utils.toEmptyBlank(req.get("noticeDate"));
		
		NoticeVo vo = new NoticeVo();
		vo.setNotice_date(noticeDate);
		int resultCnt = noticeService.sendNotice(vo);
		
		Map<String, Object> redirectMap = new HashMap<String,Object>();
		redirectMap.put("sendResult", true);
		redirectMap.put("sendCount", resultCnt);
		
		ra.addFlashAttribute("sendNoticeResult",redirectMap);
		
		return "redirect:/ifSend/noticeList.do";
	}
	
}
