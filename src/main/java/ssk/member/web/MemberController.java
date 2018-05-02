package ssk.member.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssk.member.service.MemberService;
import ssk.vo.MemberVo;

@Controller("memberController")
public class MemberController {
	
	@Resource(name="memberService")
	MemberService memberService;
	
	@RequestMapping("/member/memberList.do")
	public String memberList (@RequestParam Map<String,String> req, ModelMap model) {
		
		MemberVo vo = new MemberVo();
		
		List<MemberVo> list = memberService.memberList(vo);
		
		model.addAttribute("memberList",list);
		
		return "member/memberList";
	}
	
	@RequestMapping("/member/memberAddView.do")
	public String memberAddView (@RequestParam Map<String,String> req, ModelMap model) {

		List<MemberVo> list = memberService.memberList(new MemberVo());
		model.addAttribute("memberList",list);
		
		
		
		return "member/memberAdd";
	}
	
	@RequestMapping("/member/memberAdd.do")
	public String memberAdd (@RequestParam Map<String,String> req, ModelMap model) {
		
		String rtnUrl = "redirect:/member/memberList.do";
		
		MemberVo vo = new MemberVo();
		vo.setMbr_id(req.get("mbr_id"));
		vo.setMbr_code(req.get("mbr_code"));
		vo.setPwd(req.get("pwd"));
		vo.setMbr_nick(req.get("mbr_nick"));
		vo.setMbr_mail(req.get("mbr_mail"));
		vo.setArea_code(req.get("area_code"));
		vo.setMbr_gen(req.get("mbr_gen"));
		
		int resultCnt = memberService.memberAdd(vo);
		
		if(resultCnt < 1) {
			rtnUrl = "redirect:/member/memberAddView.do";
		}

		
		return rtnUrl;
	}
	
}
