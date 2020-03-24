package com.spring.homeservice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.homeservice.model.Home;

public class HomeMapper implements RowMapper<Home> {

	@Override
	public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
		Home h1 = new Home();
		h1.setId(rs.getInt(0));
		h1.setName(rs.getString(1));
		h1.setPassword(rs.getString(2));
		return h1;
	}
}
