package com.example.control.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	 @Value("${spring.datasource.url}")
	    private String datasourceUrl;

	    @Value("${spring.datasource.username}")
	    private String datasourceUsername;

	    @Value("${spring.datasource.password}")
	    private String datasourcePassword;

	    @Value("${spring.jpa.hibernate.ddl-auto}")
	    private String hibernateDdlAuto;

	    @Value("${spring.jpa.show-sql}")
	    private String showSql;

	    @Bean
	    public MyBean myBean() {
	        MyBean myBean = new MyBean();
	        myBean.setDatasourceUrl(datasourceUrl);
	        myBean.setDatasourceUsername(datasourceUsername);
	        myBean.setDatasourcePassword(datasourcePassword);
	        myBean.setHibernateDdlAuto(hibernateDdlAuto);
	        myBean.setShowSql(showSql);
	        return myBean;
	    }

}
