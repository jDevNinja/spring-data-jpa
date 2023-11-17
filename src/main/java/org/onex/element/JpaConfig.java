package org.onex.element;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JpaConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("any-name-is-ok");
		return emf;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource =
			new DriverManagerDataSource("jdbc:postgresql://localhost:5442/postgres", "user", "pass");
		dataSource.setDriverClassName("org.postgresql.Driver");
		return dataSource;
	}
}
