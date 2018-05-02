package ssk.gameinfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssk.dao.GameInfoDao;
import ssk.gameinfo.service.GameInfoService;
import ssk.vo.GameVo;

@Service("gameInfoService")
public class GameInfoServiceImpl implements GameInfoService {
	
	@Resource(name="gameInfoDao")
	GameInfoDao gameInfoDao;
	
	@Override
	public List<GameVo> gameList(GameVo vo) {
		List<GameVo> gameList = gameInfoDao.gameList(vo);
		return gameList;
	}

	@Override
	public int gameAdd(GameVo vo) {
		int gameAdd = gameInfoDao.gameAdd(vo);
		return gameAdd;
	}

	@Override
	public Map<String, Object> gameDetail(GameVo vo) {
		
		Map<String, Object> gamevo = gameInfoDao.gameDetail(vo);
		
		return gamevo;
	}
	
}
