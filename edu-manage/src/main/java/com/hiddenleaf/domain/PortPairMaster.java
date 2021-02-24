package com.hiddenleaf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.data.elasticsearch.annotations.Document;

import com.hiddenleaf.hbm.generator.DefaultPortPairIDGenerator;


@Audited
@Entity
@Table(name = "portpair_master")
@Document(indexName = "portpairmaster")
public class PortPairMaster {

	@Id
	@GenericGenerator(name = "portpair_string_id_generator", strategy = "com.hiddenleaf.hbm.generator.DefaultPortPairIDGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultPortPairIDGenerator.defaultSsequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultPortPairIDGenerator.defaultSsequenceIncrement) })
	
	@GeneratedValue(generator = "portpair_string_id_generator")
	private String id;

	private String tradeLane;

	private String originPort;

	private String originPortCode;

	private String destinationPort;

	private String destinationPortCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeLane() {
		return tradeLane;
	}

	public void setTradeLane(String tradeLane) {
		this.tradeLane = tradeLane;
	}

	public String getOriginPort() {
		return originPort;
	}

	public void setOriginPort(String originPort) {
		this.originPort = originPort;
	}

	public String getOriginPortCode() {
		return originPortCode;
	}

	public void setOriginPortCode(String originPortCode) {
		this.originPortCode = originPortCode;
	}

	public String getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}

	public String getDestinationPortCode() {
		return destinationPortCode;
	}

	public void setDestinationPortCode(String destinationPortCode) {
		this.destinationPortCode = destinationPortCode;
	}

}
