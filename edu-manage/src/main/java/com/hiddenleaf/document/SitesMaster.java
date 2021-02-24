package com.hiddenleaf.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

import com.hiddenleaf.util.Constant;

@Document(indexName = "site_master")
@Setting(settingPath = "autocomplete-analyser.json")
public class SitesMaster {

	@Id
	@Field(type = FieldType.Keyword)
	private String siteMasterId;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String site;
	private double siteLat;
	private double siteLong;

	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private List<String> siteType;
	@Field(type = FieldType.Keyword)
	private List<String> siteTypeId;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String companyId;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String email;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String telephone;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String tenant;
	@Field(type = FieldType.Keyword)
	private String tenantId;
	@Field(type = FieldType.Keyword)
	private String addressId;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String addressLine1;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String addressLine2;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String addressLine3;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String city;
	@Field(type = FieldType.Keyword)
	private String cityId;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String state;
	@Field(type = FieldType.Keyword)
	private String stateId;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String country;
	@Field(type = FieldType.Keyword)
	private String countryId;
	@MultiField(mainField = @Field(type = FieldType.Text, analyzer = Constant.ES_AUTOCOMPLETE_ANALYZER, searchAnalyzer = Constant.ES_STANDARD_ANALYZER), otherFields = {
			@InnerField(type = FieldType.Keyword, suffix = Constant.ES_KEYWORD) })
	private String zipcode;
	@Field(type = FieldType.Keyword)
	private String zipcodeId;
	private boolean recordDeleted;

	public SitesMaster() {
	}

	public SitesMaster(String siteMasterId, String site, long siteLat, long siteLong, List<String> siteType,
			List<String> siteTypeId, String companyId, String email, String telephone, String tenant, String tenantId,
			String addressId, String addressLine1, String addressLine2, String addressLine3, String city, String cityId,
			String state, String stateId, String country, String countryId, String zipcode, String zipcodeId,
			Boolean recordDeleted) {
		super();
		this.siteMasterId = siteMasterId;
		this.site = site;
		this.siteLat = siteLat;
		this.siteLong = siteLong;
		this.siteType = siteType;
		this.siteTypeId = siteTypeId;
		this.companyId = companyId;
		this.email = email;
		this.telephone = telephone;
		this.tenant = tenant;
		this.tenantId = tenantId;
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.cityId = cityId;
		this.state = state;
		this.stateId = stateId;
		this.country = country;
		this.countryId = countryId;
		this.zipcode = zipcode;
		this.zipcodeId = zipcodeId;
		this.recordDeleted = recordDeleted;
	}

	public String getSiteMasterId() {
		return siteMasterId;
	}

	public void setSiteMasterId(String siteMasterId) {
		this.siteMasterId = siteMasterId;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public double getSiteLat() {
		return siteLat;
	}

	public void setSiteLat(double siteLat) {
		this.siteLat = siteLat;
	}

	public double getSiteLong() {
		return siteLong;
	}

	public void setSiteLong(double siteLong) {
		this.siteLong = siteLong;
	}

	public List<String> getSiteType() {
		return siteType;
	}

	public void setSiteType(List<String> siteType) {
		this.siteType = siteType;
	}

	
	public List<String> getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(List<String> siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcodeId() {
		return zipcodeId;
	}

	public void setZipcodeId(String zipcodeId) {
		this.zipcodeId = zipcodeId;
	}

	public boolean isRecordDeleted() {
		return recordDeleted;
	}

	public void setRecordDeleted(boolean recordDeleted) {
		this.recordDeleted = recordDeleted;
	}

	@Override
	public String toString() {
		return "SiteMaster [siteMasterId=" + siteMasterId + ", site=" + site + ", siteLat=" + siteLat + ", siteLong="
				+ siteLong + ", siteType=" + siteType + ", siteTypeId=" + siteTypeId + ", companyId=" + companyId
				+ ", email=" + email + ", telephone=" + telephone + ", tenant=" + tenant + ", tenantId=" + tenantId
				+ ", addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", city=" + city + ", cityId=" + cityId + ", state=" + state
				+ ", stateId=" + stateId + ", country=" + country + ", countryId=" + countryId + ", zipcode=" + zipcode
				+ ", zipcodeId=" + zipcodeId + ", recordDeleted=" + recordDeleted + "]";
	}

}

