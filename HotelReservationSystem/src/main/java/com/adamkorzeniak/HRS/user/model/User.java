package com.adamkorzeniak.HRS.user.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.adamkorzeniak.HRS.appartment.model.Booking;
import com.adamkorzeniak.HRS.appartment.model.Hotel;
import com.adamkorzeniak.HRS.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
	@Column(unique = true)
    private String username;

    @NotNull
    @Email
    private String email;
    
    @NotEmpty
    @JsonIgnore
    private String password;
    
    @NotNull
    private Role role;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")    
    private List<Hotel> hotels;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")    
    private List<Booking> bookings;
    
    public boolean isOwner(Hotel hotel) {
    	return hotels.contains(hotel);
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}