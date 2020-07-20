package com.example.amssr.demo.Configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    @Profile("development")
    public DataSource development(){
       EmbeddedDatabaseBuilder db=new EmbeddedDatabaseBuilder();
        db.setType(EmbeddedDatabaseType.H2);
        db.addScript("sql/table.sql");

        db.addScript("sql/data.sql");
        return db.build();
    }
}
