package br.com.portal.request;

import java.io.Serializable;

public class AuthRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1484789238657090939L;
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
