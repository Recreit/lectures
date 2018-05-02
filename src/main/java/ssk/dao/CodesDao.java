package ssk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssk.vo.CodesVo;

@Repository("codesDao")
public class CodesDao extends Mapper {

	public List<CodesVo> codesList(CodesVo vo) {
		return selectList("codesList",vo);
	}

}
