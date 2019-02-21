package br.com.sandbox.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class JwtAuthenticationDto {

	private String username;
	private String password;
	@JsonProperty("app_id")
	private String appId;
	
	

	public JwtAuthenticationDto() {
	}

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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	

	

}
