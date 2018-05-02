package com.ohhoonim.common.typehandler;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.DATE)
public class DateTypeHandler extends BaseTypeHandler<String>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter);
		
	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String result = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date colValue = rs.getDate(columnName);
		if (colValue != null) {
			result = sf.format(colValue);
		} else {
			result = "1970-01-01";
		}
		
		return result;
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String result = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date colValue = rs.getDate(columnIndex);
		if (colValue != null) {
			result = sf.format(colValue);
		} else {
			result = "1970-01-01";
		}
		
		return result;
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String result = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date colValue = cs.getDate(columnIndex);
		if (colValue != null) {
			result = sf.format(colValue);
		} else {
			result = "1970-01-01";
		}
		
		return result;
	}

	



}
