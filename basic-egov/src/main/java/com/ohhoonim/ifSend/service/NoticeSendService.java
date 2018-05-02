package com.ohhoonim.ifSend.service;

import java.util.List;

import com.ohhoonim.vo.NoticeVo;

public interface NoticeSendService {

	List<NoticeVo> noticeList(NoticeVo vo);

	public int sendNotice(NoticeVo vo);

}
