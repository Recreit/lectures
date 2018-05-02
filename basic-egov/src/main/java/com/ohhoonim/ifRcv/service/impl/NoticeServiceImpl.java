package com.ohhoonim.ifRcv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.NoticeDao;
import com.ohhoonim.ifRcv.service.NoticeService;
import com.ohhoonim.vo.NoticeVo;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Resource(name="noticeDao")
	NoticeDao noticeDao;

	@Override
	public List<NoticeVo> noticeList(NoticeVo vo) {
		List<NoticeVo> noticeList = noticeDao.noticeList(vo);
		return noticeList;
	}
}
