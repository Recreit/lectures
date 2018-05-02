package com.ohhoonim.member;

import com.ohhoonim.vo.MemberVo;

public interface MemberService {

	boolean isMember(MemberVo vo);

	MemberVo findMemberById(MemberVo vo);

	int addMember(MemberVo vo);

}
