package ssk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ssk.vo.GameVo;
import ssk.vo.GenreVo;

@Repository("gameInfoDao")
public class GameInfoDao extends Mapper {
	public List<GameVo> gameList(GameVo vo) {
		return selectList("gameList",vo);
	}

	public int gameAdd(GameVo vo) {
		return insert("gameAdd",vo);
	}

	public Map<String, Object> gameDetail(GameVo vo) {
		//Map<String, Object> =  selectOne("GameInfo.gameDetail",vo);
		//List<GenreVo> gamegenreDetail = selectList("Genre.genreDetail",vo);
		//gameDetail.put("genre", gamegenreDetail);
		return selectOne("GameInfo.gameDetail",vo);
	}
}
