package com.hiddenleaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "icargo_configuration")
@Document(indexName = "icargo_configuration")
public class IcargoConfiguration {

	@Id
	@Column(name="comp_id")
	private Long componetId;
	
	@Column(name="comp_desc")
	private String componetDesc;
	
	private String value;
	
	public Long getComponetId() {
		return componetId;
	}

	public void setComponetId(Long componetId) {
		this.componetId = componetId;
	}

	public String getComponetDesc() {
		return componetDesc;
	}

	public void setComponetDesc(String componetDesc) {
		this.componetDesc = componetDesc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}


