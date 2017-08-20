package com.adamkorzeniak.HRS.security;

public enum Role {

	TENANT,
	LANDLORD,
	BOTH,
	ADMIN;
	
	public boolean isTenant() {
		return this.equals(TENANT) || this.equals(BOTH);
	}
	
	public boolean isLandlord() {
		return this.equals(LANDLORD) || this.equals(BOTH);
	}
	
	public boolean isAdmin() {
		return this.equals(ADMIN);
	}
}
