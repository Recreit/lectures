package com.ohhoonim.member.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.MemberDao;
import com.ohhoonim.member.MemberService;
import com.ohhoonim.vo.MemberVo;

@Service("memberService") 
public class MemberServiceImpl implements MemberService {
	
	@Resource(name="memberDao")
	MemberDao memberDao;

	@Override
	public boolean isMember(MemberVo vo) {
		boolean isMember = false;
		
		int resultCnt = memberDao.isMember(vo);
		// dm; -> select count(0) from tb_member...
		
		if (resultCnt > 0) {
			isMember = true;
		}
		
		return isMember;
	}

	@Override
	public MemberVo findMemberById(MemberVo vo) {
		
		MemberVo memberInfo = memberDao.findMemberById(vo);
		
		return memberInfo;
	}

	@Override
	public int addMember(MemberVo vo) {
		
		int addMember = memberDao.addMember(vo);
		
		return addMember;
	}
	
}
