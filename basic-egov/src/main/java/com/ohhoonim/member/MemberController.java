package com.ohhoonim.member;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohhoonim.vo.MemberVo;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	MemberService memberService;
	
	@RequestMapping("/main.do")
	public String main (@RequestParam Map<String, String> req, ModelMap model) {
		
		return "member/main";
	}
	
	@RequestMapping("/Login.do")
	public String login (@RequestParam Map<String, String> req, ModelMap model) {
		
		return "member/login";
	}
	
	@RequestMapping("/LoginProcess.do")
	public String LoginProcess (@RequestParam Map<String, String> req, ModelMap model, HttpSession session) {
		String retrunurl = "redirect:/main.do";
		
		String id = req.get("id");
		String pwd = req.get("pwd");
		
		MemberVo vo = new MemberVo();
		vo.setMbr_id(id);
		vo.setPwd(pwd);
		
		boolean isMember = memberService.isMember(vo);
		
		model.addAttribute("isMember",isMember);
		
		if (isMember) {
			MemberVo memberInfo = memberService.findMemberById(vo);
			
			session.setAttribute("memberInfo", memberInfo);
			session.setAttribute("memberId", memberInfo.getMbr_id());
			
		} else {
			retrunurl = "redirect:/Login.do?loginFail=true";	
		}
		
		return retrunurl;
	}
	
	@RequestMapping("/signUp.do")
	public String signUp (@RequestParam Map<String, String> req, ModelMap model) {
		
		return "member/signUp";
	}
	
	@RequestMapping("/signUpProcess.do")
	public String signUpProcess (@RequestParam Map<String, String> req, ModelMap model, HttpSession session) {
		
		MemberVo vo = new MemberVo();
		
		vo.setMbr_id(req.get("mbr_id"));
		vo.setMbr_code(req.get("mbr_code"));
		vo.setPwd(req.get("pwd"));
		vo.setContact(req.get("contact"));
		vo.setSav_pnt(req.get("sav_pnt"));
		vo.setBuy_pnt(req.get("buy_pnt"));
		vo.setChn_id(req.get("chn_id"));
		
		int resultCnt = memberService.addMember(vo);
		
		session.setAttribute("memberId", vo.getMbr_id());

		return "member/signupResult";
	}
	
	@RequestMapping("/memberInfo.do")
	public String memberInfo (@RequestParam Map<String, String> req, ModelMap model, HttpSession session) {
		String returnUrl = "member/memberInfo";
		
		String memberId = (String) session.getAttribute("memberId");
		
		if (memberId == null) {
			returnUrl = "redirect:/main.do";
		} else {
			MemberVo vo = new MemberVo();
			vo.setMbr_id(memberId);
			
			MemberVo memberVo = memberService.findMemberById(vo);
			
			model.addAttribute("memberVo", memberVo);
		}
		
		return returnUrl;
	}
	
	@RequestMapping("/logout.do")
	public String logout (@RequestParam Map<String, String> req, ModelMap model, HttpSession session) {
		
		session.removeAttribute("memberInfo");
		session.removeAttribute("memberId");
		
		return "redirect:/main.do";
	}
	
	
	
	
}
