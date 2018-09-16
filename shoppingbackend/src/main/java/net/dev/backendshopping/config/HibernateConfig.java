package net.dev.backendshopping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages={"net.dev.backendshopping.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	/*private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";*/
	
	/*private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/dbx";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "";*/
	
	
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		dataSource.setMaxIdle(25);
		dataSource.setMinIdle(5);
		dataSource.setMaxWaitMillis(10000);
									
		return dataSource;
		
	}
	
	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
			
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.dev.backendshopping.dto");
		
		return builder.buildSessionFactory();
		
		
	}


	private Properties getHibernateProperties() {

		Properties properties = new Properties();		
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.auto_close_session", "true");
		
		// c3po	
		properties.put("hibernate.c3p0.acquire_increment", "1");
		properties.put("hibernate.c3p0.idle_test_period", "3000");		
		properties.put("hibernate.c3p0.max_size", "25");
		properties.put("hibernate.c3p0.min_size", "10");
		
		properties.put("hibernate.c3p0.timeout", "1800");
		properties.put("hibernate.c3p0.max_statement", "50");
		
		
		return properties;
	}
	
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory) {
	
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionfactory);
		
		return transactionManager;
		
	}
	

}
