package ssk.member.service;

import java.util.List;

import ssk.vo.MemberVo;

public interface MemberService {

	List<MemberVo> memberList(MemberVo vo);

	int memberAdd(MemberVo vo);

}
