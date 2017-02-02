package config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import model.Todo;

@Configuration
@ComponentScan({ "bo", "dao", "model" })
@EnableTransactionManagement
public class TodoConfig {
	@Bean
	@Scope("singleton")
	public SessionFactory sessionFactory() {
		System.out.println("Session factory sysout.");
		SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Todo.class).buildSessionFactory();
		System.out.println(factory);
		return factory;
	}

	// @Bean
	// public PlatformTransactionManager transactionManager() {
	// JpaTransactionManager transactionManager = new
	// JpaTransactionManager(entityManagerFactory());
	// transactionManager.setDataSource(dataSource);
	// transactionManager.setJpaDialect(new HibernateJpaDialect());
	// return transactionManager;
	// }

}
