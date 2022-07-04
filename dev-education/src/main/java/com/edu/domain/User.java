package com.edu.domain;

import lombok.Data;

@Data
public class User {
	private long id;
	private String loginId;
	private String name;
	private String zipNo;
	private String  address;
}
