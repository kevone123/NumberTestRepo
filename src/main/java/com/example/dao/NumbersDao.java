package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.BadRequestException;
import com.example.pojo.NumberObj;

@Repository
public class NumbersDao {
	
	@Autowired
    private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	  public void saveNumber(NumberObj number) {
	      String sql = "insert into NUMBER (ID, NAME) values (?, ?)";
	      jdbcTemplate.update(sql, number.getNumberID(), number.getNumberName()
	             );
	  }
	  
	  public List<NumberObj> getNumbers() {
	      return (List<NumberObj>) jdbcTemplate.query("select * from NUMBER", new toNumberMapper());
	  }
	  
	  public class toNumberMapper implements RowMapper<NumberObj>{
		  
		@Override
		public NumberObj mapRow(ResultSet rs, int rowNum) throws SQLException {
			NumberObj number = new NumberObj();
		    number.setNumberID(rs.getInt(("ID")));
		    number.setNumberName((rs.getString("NAME")));
		    return number;
		}
	}

	public NumberObj getNumberById(long id) {
		String sql = "select * from NUMBER where ID = " + id;
	   return (NumberObj) jdbcTemplate.query(sql, new toNumberMapper());
	}
	
	@Transactional
	public void insertNumber(NumberObj number) {
	    String sql ="insert into NUMBER (ID, NAME) values (?, ?)";
	    System.out.printf("id is %s and name is %s", number.getNumberID(), number.getNumberName());
	    try { 
	    	jdbcTemplate.update(sql, number.getNumberID(), number.getNumberName());
	    } catch(BadRequestException ex) {
	    	ex.printStackTrace();
	    }
	}

	public void updateNumber(NumberObj number) {
		String sql = "update NUMBER set NAME  = ? where ID = ? ";
		 jdbcTemplate.update(sql, number.getNumberName(), number.getNumberID());
	}

}
