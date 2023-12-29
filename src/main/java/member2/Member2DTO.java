package member2;

import lombok.Data;

@Data
public class Member2DTO {
	
	private String id;
	private String name;
	private String pass1;
	private String sex;
	private String hobby1;
	private String hobby2;
	private String hobby3;
	private String hobby4;
	private String nation;
	private String zone;
	private String phone1;
	private String phone2;
	private String profile;

	

}
/*
create table member2 (
id varchar2(200) not null primary key,
name varchar2(100) not null,
pass1 varchar2(200) not null,
sex char(3) not null,
hobby1 varchar2(200) null,
hobby2 varchar2(200) null,
hobby3 varchar2(200) null,
hobby4 varchar2(200) null,
nation varchar2(200) not null,
zone varchar2(200) not null,
phone1 varchar2(200) not null,
phone2 varchar2(200) not null,
profile varchar2(200)
);
*/