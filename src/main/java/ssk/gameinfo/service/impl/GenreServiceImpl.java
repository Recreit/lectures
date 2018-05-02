package ssk.gameinfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssk.dao.GenreDao;
import ssk.gameinfo.service.GenreService;
import ssk.vo.GameVo;
import ssk.vo.GenreVo;

@Service("genreService")
public class GenreServiceImpl implements GenreService {
	
	@Resource(name="genreDao")
	GenreDao genreDao;

	@Override
	public Map<String,List<GenreVo>> genreList(GameVo vo) {
		Map<String,List<GenreVo>> genreList = genreDao.genreList(vo);
		return genreList;
	}
	
}
