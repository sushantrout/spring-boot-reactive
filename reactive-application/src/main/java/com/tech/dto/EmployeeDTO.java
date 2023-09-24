package com.tech.dto;

import com.tech.model.Gender;

import java.io.Serializable;

public record EmployeeDTO(int id, String name, int age, Gender gender, double salary) implements Serializable {}

