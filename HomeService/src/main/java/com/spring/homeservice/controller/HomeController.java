package com.spring.homeservice.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.spring.homeservice.jpa.HomeJpa;
import com.spring.homeservice.mapper.HomeMapper;
import com.spring.homeservice.model.Home;

@RequestMapping("/home")
@RestController
public class HomeController {

	public Home home1;

	public HomeController() {
		home1 = new Home("prathyu", "password");
	}

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HomeJpa homeJpa;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/name")
	public String getName() {
		String url = "http://localhost:9090/dockerCtrl/get";
		System.out.println("URL-->" + url);
		String returnedString = restTemplate.getForObject(url, String.class);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				});
		String output = response.getBody();
		return output;
	}

	@RequestMapping("/saveRecord")
	public void saveUser() {
		homeJpa.save(home1);
	}

	@RequestMapping("/getAll")
	public List<Home> getAll() {
//		jdbcTemplate.query("select * from home", new RowMapper<Home>() {
//			@Override
//			public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
//				System.out.println(rs.getInt(0) + "---" + rs.getString(1));
//				return null;
//			}
//		});
		List<Home> all = homeJpa.findAll();
		return all;
	}

	public void addOne() {

	}
	
	

	@RequestMapping("/getOne")
	public String getOne(int id) {
		SqlParameterSource source = new MapSqlParameterSource().addValue("id", id);
		String name = namedParameterJdbcTemplate.queryForObject("select name from home where id = :id", source,
				String.class);
		return name;
	}

	public void getOneRecord(int id1) {
//		SqlParameterSource source = new MapSqlParameterSource().addValue("id", id1);
		jdbcTemplate
				.query("select id,name,password from home where id = ?", new Object[] { id1 },
						(rs, rowNum) -> new Home(id1, rs.getString("name"), rs.getString("password")))
						.forEach(home -> System.out.println(home.toString()));
	}

}
