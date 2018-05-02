package ssk.codes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssk.codes.service.CodesService;
import ssk.dao.CodesDao;
import ssk.vo.CodesVo;

@Service("codesService")
public class CodesServiceImpl implements CodesService {
	
	@Resource(name="codesDao")
	CodesDao codesDao;
	
	@Override
	public List<CodesVo> codesList(CodesVo vo) {
		List<CodesVo> codesList = codesDao.codesList(vo);
		return codesList;
	}

}
