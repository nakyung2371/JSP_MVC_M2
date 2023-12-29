package test;

import member2.Member2DAO;
import member2.Member2DTO;

public class Member2_Insert_Test {

	public static void main(String[] args) {
		
		Member2DTO dto = new Member2DTO();
		
		dto.setId("1111");
		dto.setName("홍길동");
		dto.setPass1("1234");
		dto.setSex("여성");
		dto.setHobby1(null);
		dto.setHobby2(null);
		dto.setHobby3(null);
		dto.setHobby4(null);
		dto.setNation("082");
		dto.setZone("010");
		dto.setPhone1("2222");
		dto.setPhone2("3333");
		dto.setProfile("반갑습니다.");
		
		Member2DAO dao = new Member2DAO();
		dao.member2Insert(dto);
		

	}

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
phone1 varchar2(5) not null,
phone2 varchar2(5) not null,
profile varchar2(200)
);
*/