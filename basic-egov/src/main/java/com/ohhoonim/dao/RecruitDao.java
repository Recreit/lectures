package com.ohhoonim.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.NoticeVo;

@Repository("recruitDao")
public class RecruitDao extends Mapper {

	public List<NoticeVo> noticeList(NoticeVo vo) {
		return selectList("recruitList",vo);
	}

}
