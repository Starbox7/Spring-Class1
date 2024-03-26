//JDBC 사용

package com.example.web.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.example.web.domains.User;

// @Repository
public class JdbcTemplateUserRepository implements UserRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcTemplateUserRepository(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }
    
    public User add(User user) {
      SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
      jdbcInsert.withTableName("users").usingGeneratedKeyColumns("index");
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("id", user.getId());
      parameters.put("password", user.getPassword());
      Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
      user.setIndex(key.longValue());
      return user;
    }

    // id 중복 확인
    @Override
    public Optional<User> findById(String id) {
      List<User> result = jdbcTemplate.query("select * from users where id = ?", userRowMapper(), id);
      return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select*from users", userRowMapper());
        
    }

    private RowMapper<User> userRowMapper() {
      return (rs, rowNum) -> {
        User user = new User();
        user.setIndex(rs.getLong("index"));
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));
        return user;
      };
    }
}
