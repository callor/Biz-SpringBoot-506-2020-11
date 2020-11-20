package com.biz.bbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
/**
 * JPA 기능을 사용하여 자동 table 생성을 하도록 설정
 * @Entity : JPA에서 논리적인 연산을 수행할때 사용하도록 설정 
 * @Table : 물리적 table을 만들때 사용하도록 설정
 * tbl_bbs라는 table을 필드변수를 칼럼값으로 하여 만들어 사용하겠다.
 */
@Entity
@Table(name="tbl_bbs")
public class BBsVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long b_id;
	
	@Column(columnDefinition = "VARCHAR(30)")
	private String b_writer;
	
	@Column(length = 50)
	private String b_date_time;
	
	@Column(columnDefinition = "VARCHAR(125)")
	private String b_subject;
	
	@Column(columnDefinition = "VARCHAR(2000)")
	private String b_content;
	
	private int b_count;

}
