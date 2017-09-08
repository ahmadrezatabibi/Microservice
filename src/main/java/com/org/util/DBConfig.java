/**
 * 
 */
package com.org.util;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author ahmadrezatabibi
 * 
 * Database config will be here
 *
 */
@SpringBootConfiguration
public class DBConfig {
	
	@Bean
	public DataSource dataSource(){
		EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
		databaseBuilder.setName("DBtest");
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	}

	@Bean
    ServletRegistrationBean h2servletRegistration() throws SQLException{
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
