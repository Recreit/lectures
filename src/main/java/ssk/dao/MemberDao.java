package ssk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssk.vo.MemberVo;

@Repository("memberDao")
public class MemberDao extends Mapper {

	public List<MemberVo> memberList(MemberVo vo) {
		return selectList("memberList",vo);
	}

	public int memberAdd(MemberVo vo) {
		return insert("memberAdd",vo);
	}

}
