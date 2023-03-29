package com.prodemy.taopik.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public @Data class Admin {
	@Id
	private String username;
	private String password;
}
