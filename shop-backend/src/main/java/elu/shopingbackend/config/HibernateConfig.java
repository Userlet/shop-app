package elu.shopingbackend.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
/*@PropertySource("classpath:db.properties")*/
@ComponentScan(basePackages = { "elu.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL="jdbc:mysql://localhost:3306/onlineshopping?autoReconnect=true&useSSL=false";
	private final static String DATABASE_DRIVER="com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME="test_leti";
	private final static String DATABASE_PW="LETIpasswd";
	
	@Bean
	private DataSource getDataSource() {
		
		BasicDataSource dataSource=new BasicDataSource();		
		//providing the db connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PW);
		
	return dataSource;
	}
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("elu.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}
	
	//All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {

		Properties properties=new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql","true");
		return null;
	}
	
	//transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionaManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager  =new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	

}
