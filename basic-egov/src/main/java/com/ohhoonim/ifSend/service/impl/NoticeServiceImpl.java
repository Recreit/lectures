package com.ohhoonim.ifSend.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.NoticeDao;
import com.ohhoonim.dao.RecruitDao;
import com.ohhoonim.ifSend.service.NoticeSendService;
import com.ohhoonim.vo.NoticeVo;

@Service("noticeSendService")
public class NoticeServiceImpl implements NoticeSendService {
	
	@Resource(name="noticeDao")
	NoticeDao noticeDao;
	
	@Resource(name="recruitDao")
	RecruitDao recruitDao;
	
	@Override
	public List<NoticeVo> noticeList(NoticeVo vo) {
		List<NoticeVo> noticeList = recruitDao.noticeList(vo);
		return noticeList;
	}
	
	public int sendNotice(NoticeVo vo) {
		//1.송신할 데이터를 불러온다.
		List<NoticeVo> list = recruitDao.noticeList(vo);
		
		//2.기존 데이터를 삭제한다.
		noticeDao.removeNotice(vo);
		
		//3.데이터를 loop 돌면서 tb_notice insert 쿼리를 실행한다.
		int resultCnt = 0;
		for (NoticeVo notice : list) {
			resultCnt += noticeDao.addNotice(notice);
		}
		
		//3.입력된 데이터 개수를 리턴해준다.
		return resultCnt; 
	}
	
}
