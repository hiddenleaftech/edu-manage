package com.hiddenleaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.data.elasticsearch.annotations.Document;

import com.hiddenleaf.hbm.generator.DefaultSiteIDGenerator;
import com.hiddenleaf.util.Identifiable;

@Audited
@Entity
@Table(name = "site_master")
@Document(indexName = "site_master")
public class SiteMaster extends AbstractAuditingEntity implements Identifiable<String> {

	private static final long serialVersionUID = 1L;

	@Id
//	@GenericGenerator(name = "sitemaster_string_id_generator", strategy = "com.wdsi.microservice.cntms.hbm.generator.DefaultSiteIDGenerator", parameters = {
//			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultSiteIDGenerator.defaultsSequencePrefix),
//			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultSiteIDGenerator.defaultSsequenceIncrement) })
//	@GeneratedValue(generator = "sitemaster_string_id_generator")

	private String id;
	@Column
	private String siteName;
	
	@Column
	private String accountID;

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

}
