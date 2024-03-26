package com.example.web.global.config;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostgreSQLConfig implements ApplicationRunner {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public PostgreSQLConfig(DataSource dataSource,
                            JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()){
            System.out.println("dataSource Class > " + dataSource.getClass());
            System.out.println("URL > " + connection.getMetaData().getURL());
            System.out.println("userName > " + connection.getMetaData().getUserName());

            // Statement statement = connection.createStatement(); // 수정된 라인
            // String sql = "CREATE TABLE SPRING_TODO_TEST(NO INTEGER NOT NULL, TEST_NAME VARCHAR(255), PRIMARY KEY (NO))";
            // statement.executeUpdate(sql);
        }

        // jdbcTemplate.execute("INSERT INTO SPRING_TODO_TEST VALUES (2, 'starbox918')");
    }
}
