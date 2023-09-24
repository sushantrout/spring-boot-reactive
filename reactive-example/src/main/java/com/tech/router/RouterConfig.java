package com.tech.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tech.handler.CustomerServiceHandler;

@Configuration
public class RouterConfig {

	@Autowired
	private CustomerServiceHandler customerServiceHandler;

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route().GET("/router/customers", customerServiceHandler::getCustomers).build();

	}
}
