package com.example.amssr.demo.Configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.example.amssr.demo.respository")
public class MyBatisConfiguration {
    @Autowired
    public DataSource dataSource;
    @Bean
    public SqlSessionFactoryBean sessionFactoryBean(){
        SqlSessionFactoryBean sql=new SqlSessionFactoryBean();
        sql.setDataSource(dataSource);
        return sql;
    }
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }
}
