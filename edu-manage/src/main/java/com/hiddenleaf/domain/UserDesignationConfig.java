package com.hiddenleaf.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "user_designation")
@Document(indexName = "user_designation")
public class UserDesignationConfig {

	@Id
	private Long id;

	private String value;

	private String code;

	public Long getId() {	
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
