package com.billlog.miribojobapi.global.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecodeTokenVo {
	private String sub;
	private Info info;
	private String roles;

	@Getter
	@Setter
	public static class Info{
		private String userId;
		private String name;
		private String account;
		private String symbol;
		private String email;

    }
	
}
