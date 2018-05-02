package com.ohhoonim.dao;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.MemberVo;

@Repository("memberDao")
public class MemberDao extends Mapper {

	public int isMember(MemberVo vo) {
		return selectOne("isMember", vo);
	}

	public MemberVo findMemberById(MemberVo vo) {
		return selectOne("findMemberById",vo);
	}

	public int addMember(MemberVo vo) {
		return insert("addMember", vo);
	}
	
}
