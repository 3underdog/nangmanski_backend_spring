package com.dev.nangmanski_backend_spring.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = { "com.dev.**.mapper" })
@EnableTransactionManagement
public class DatabaseConfig {
    @Bean
    @SpringSessionDataSource
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:mybatis/mapper/**/*.xml"));
        SqlSessionFactory factory = sessionFactory.getObject();
        factory.getConfiguration().setCacheEnabled(false); // Query Cache 여부
        factory.getConfiguration().setUseGeneratedKeys(true); // Insert Generate Key 사용여부
        factory.getConfiguration().setMapUnderscoreToCamelCase(true); // CamelCase 변환 여부

        return factory;
    }
}
