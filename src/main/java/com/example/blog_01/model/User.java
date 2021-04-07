package com.example.blog_01.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //User 클래스가 MySQL에 테이블 생성
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다. 
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 30)
	private String username; //아이디
	
	@Column(nullable = false, length = 100) //hash(비밀번호 암호화)
	private String password; //비밀번호
	
	@Column(nullable = false, length = 50)
	private String email; //이메일
	
	@ColumnDefault("'user'")
	private String role; //Enum //admin,user,manager
	
	@CreationTimestamp //시간 자동 입력
	private Timestamp createDate; //날짜,시간
	
}//class
