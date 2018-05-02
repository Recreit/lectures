package ssk.member.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssk.dao.MemberDao;
import ssk.member.service.MemberService;
import ssk.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl  implements MemberService{
	
	@Resource(name="memberDao")
	MemberDao memberDao;
	
	@Override
	public List<MemberVo> memberList(MemberVo vo) {
		List<MemberVo> memberList = memberDao.memberList(vo);
		return memberList;
	}

	@Override
	public int memberAdd(MemberVo vo) {
		int memberAdd = memberDao.memberAdd(vo);
		return memberAdd;
	}

}
