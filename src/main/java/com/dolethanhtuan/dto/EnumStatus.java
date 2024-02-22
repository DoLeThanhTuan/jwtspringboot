package com.dolethanhtuan.dto;

public enum EnumStatus {
	Active(1),
	InActive(0);

	private final int statusCode;
	
	EnumStatus(int i) {
		this.statusCode = i;
	}
	public int getStatusCode() {
		return this.statusCode;
	}
}
