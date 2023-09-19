package com.tech.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class EmployeeController {
	
	private final DataSource dataSource;
	
	@GetMapping
	public Connection getDatasource() throws SQLException {
		return dataSource.getConnection();
	}
	
	
}
