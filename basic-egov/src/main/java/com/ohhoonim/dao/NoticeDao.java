package com.ohhoonim.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.NoticeVo;

@Repository("noticeDao")
public class NoticeDao extends Mapper {

	public List<NoticeVo> noticeList(NoticeVo vo) {
		return selectList("Notice.noticeList",vo);
	}

	public int addNotice(NoticeVo notice) {
		return insert("addNotice",notice);
	}
	
	public int removeNotice(NoticeVo notice) {
		return delete("removeNotice",notice);
	}

}
