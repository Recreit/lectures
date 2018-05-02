package ssk.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import ssk.common.AbstractMapper;

public class Mapper extends AbstractMapper {
	
	@Resource(name = "sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
}
