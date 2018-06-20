package com.duduanan.crm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.duduanan.crm.entity.Customer;

import static org.hibernate.cfg.Environment.*;
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.duduanan.crm.entity")})
public class HibernateConfig {

	@Autowired
	Environment env;
	
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(env.getProperty("msyql.driver"));//"com.mysql.jdbc.Driver"
	    dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
	    dataSource.setUsername(env.getProperty("mysql.username"));
	    dataSource.setPassword(env.getProperty("mysql.password"));
	    return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setPackagesToScan("com.duduanan.crm.entity");
		Properties props=new Properties();
		//Setting JDBC properties
		
		
		//Setting Hibernate properties
		props.put(SHOW_SQL, true);
		props.put(HBM2DDL_AUTO, "validate");
		// props.put(DIALECT, env.getProperty("hibernate.dialect"));
		
		//setting C3P0 properties
		props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		props.put(C3P0_TIMEOUT,env.getProperty("hibernate.c3p0.timeout"));
		props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));		
		factoryBean.setHibernateProperties(props);
		return factoryBean;
	}
	
     @Bean
	public HibernateTransactionManager getTransactionManager(){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
	
}
