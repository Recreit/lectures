package ssk.gameinfo.service;

import java.util.List;
import java.util.Map;

import ssk.vo.GameVo;
import ssk.vo.GenreVo;

public interface GenreService {

	Map<String,List<GenreVo>> genreList(GameVo vo);

}
