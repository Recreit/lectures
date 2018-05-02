package com.ohhoonim.common.service.impl;

import java.io.File;
import java.net.URLEncoder;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ohhoonim.common.service.FilesService;
import com.ohhoonim.dao.FilesDao;
import com.ohhoonim.vo.FilesVo;

@Service("filesService")
public class FilesServiceImpl implements FilesService {

	@Resource(name = "filesDao")
	FilesDao dao;

	public FilesVo selectFiles(FilesVo vo) {
		return dao.selectFiles(vo);
	}

	public String addFiles(MultipartFile file, String contextPath) throws Exception {
		String fileName = file.getOriginalFilename();
		String contentType = file.getContentType();
		String uploadedFileName = System.currentTimeMillis() + UUID.randomUUID().toString()
				+ fileName.substring(fileName.lastIndexOf("."));
		String uploadPath = "/upload";

		if (file.getSize() != 0) {
			file.transferTo(new File(uploadPath + "/" + uploadedFileName));
		}
		String nextFilesId = dao.getNextId();
		String downlink = contextPath + "/common/download.do?filesId=" + nextFilesId;

		FilesVo vo = new FilesVo();
		vo.setFilesId(nextFilesId);
		vo.setFilesNm(fileName);
		vo.setFilesUfn(uploadedFileName);
		vo.setFilesSize(file.getSize() + "");
		vo.setFilesType(contentType);
		vo.setFilesDl(downlink);
		
		dao.addFiles(vo);
		
		return nextFilesId;
	}

	public int updateFiles(FilesVo vo) {
		return dao.updateFiles(vo);
	}

	public int deleteFiles(FilesVo vo) {
		return dao.deleteFiles(vo);
	}

}
