package br.com.portal.response;

import java.io.Serializable;

public class AuthResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2540383966055396013L;
	
	private String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public AuthResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public AuthResponse() {
		super();
	}
	
	
}
