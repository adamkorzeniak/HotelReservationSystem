package com.adamkorzeniak.HRS.user.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.adamkorzeniak.HRS.security.Role;

public class UserDTO {
	
    @NotEmpty
	@Column(unique = true)
    private String username;

    @NotNull
    @Email
    private String email;
    
    @NotEmpty
    private String password;
    
    @NotNull
    private Role role;
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}