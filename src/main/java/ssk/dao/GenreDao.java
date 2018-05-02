package ssk.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ssk.vo.GameVo;
import ssk.vo.GenreVo;

@Repository("genreDao")
public class GenreDao extends Mapper{

	public Map<String,List<GenreVo>> genreList(GameVo vo) {
		List<GenreVo> list = selectList("genreList",vo);
		Map<String,List<GenreVo>> genreList = new HashMap<String,List<GenreVo>>();
		for(GenreVo code : list) {
			List<GenreVo> codeList = null;
			if(genreList.containsKey(code.getGame_id())) {
				codeList = genreList.get(code.getGame_id());
				codeList.add(code);
			} else {
				codeList = new ArrayList<GenreVo>();
				codeList.add(code);
				genreList.put(code.getGame_id(), codeList);
			}
		}
		
		return genreList;
	}

}
