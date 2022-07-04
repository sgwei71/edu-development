package com.edu.config;

import java.io.IOException;
import java.util.AbstractSequentialList;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.edu", sqlSessionFactoryRef ="sqlSessionFactory")
public class DBConfig {
	
	@Value("${spring.datasource.mapper-locations}")
	String mPath;
	
	//myBatis설정 파일을 따로 작성해서 임포트할 예정
	@Value("${mybatis.config-location}")
	String mybatisConfigPath;
	
	@Bean(name = "dataSource")
	@ConfigurationProperties( prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}                                                                                                                                                                                                                                                                                                                                                                                                           
	
	@Bean( name = "sqlSessionFactory")
	public SqlSessionFactory SqlSessionFactory(@Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext ) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mPath));
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(mybatisConfigPath));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name = "sessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory firstSqlSessionFactory) {
		return new SqlSessionTemplate(firstSqlSessionFactory);
	}
	
}
