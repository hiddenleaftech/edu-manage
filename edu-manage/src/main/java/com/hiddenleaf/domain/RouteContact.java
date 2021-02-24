package com.hiddenleaf.domain;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.data.elasticsearch.annotations.Document;

import com.hiddenleaf.hbm.generator.DefaultRouteContactIDGenerator;


@Audited
@Entity
@Table(name = "route_contact")
@Document(indexName = "route_contact")
public class RouteContact extends AbstractAuditingEntity {
	

	@Id
	@GenericGenerator(name = "routecontact_string_id_generator", strategy = "com.hiddenleaf.hbm.generator.DefaultRouteContactIDGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultRouteContactIDGenerator.defaultSsequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultRouteContactIDGenerator.defaultSsequenceIncrement) })
	
	@GeneratedValue(generator = "routecontact_string_id_generator")
	private String id;

	private String source; //orginCountryCode

	private String destination; //destinationCountryCode

	private String RVWLaneID;

	private String laneName;

	private String orginCountryName;

	private String orginPortLocation;

	private String destinationCountryName;

	private String destinationPortLocation;

	private String travelDuration;

	private Long d1Days;

	@Transient
	private String emailList;
	
	@Transient
	private String emailCCList;
	
	@Column(name="Charge_Code_Type")
	private String chargecodetype;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRVWLaneID() {
		return RVWLaneID;
	}

	public void setRVWLaneID(String rVWLaneID) {
		RVWLaneID = rVWLaneID;
	}

	public String getLaneName() {
		return laneName;
	}

	public void setLaneName(String laneName) {
		this.laneName = laneName;
	}

	public String getOrginCountryName() {
		return orginCountryName;
	}

	public void setOrginCountryName(String orginCountryName) {
		this.orginCountryName = orginCountryName;
	}

	public String getOrginPortLocation() {
		return orginPortLocation;
	}

	public void setOrginPortLocation(String orginPortLocation) {
		this.orginPortLocation = orginPortLocation;
	}

	public String getDestinationCountryName() {
		return destinationCountryName;
	}

	public void setDestinationCountryName(String destinationCountryName) {
		this.destinationCountryName = destinationCountryName;
	}

	public String getDestinationPortLocation() {
		return destinationPortLocation;
	}

	public void setDestinationPortLocation(String destinationPortLocation) {
		this.destinationPortLocation = destinationPortLocation;
	}

	public String getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}

	public Long getD1Days() {
		return d1Days;
	}

	public void setD1Days(Long d1Days) {
		this.d1Days = d1Days;
	}

	public String getEmailList() {
		return emailList;
	}

	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}

	public String getChargecodetype() {
		return chargecodetype;
	}

	public void setChargecodetype(String chargecodetype) {
		this.chargecodetype = chargecodetype;
	}

	public String getEmailCCList() {
		return emailCCList;
	}

	public void setEmailCCList(String emailCCList) {
		this.emailCCList = emailCCList;
	}

}
