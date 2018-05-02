package ssk.gameinfo.service;

import java.util.List;
import java.util.Map;

import ssk.vo.GameVo;

public interface GameInfoService {

	List<GameVo> gameList(GameVo vo);

	int gameAdd(GameVo vo);

	Map<String, Object> gameDetail(GameVo vo);
	
}
