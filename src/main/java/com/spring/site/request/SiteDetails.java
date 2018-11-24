package com.spring.site.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "siteID", "name", "location", "customerId" })
public class SiteDetails implements Serializable {

	@JsonProperty("siteID")
	private String siteID;
	@JsonProperty("name")
	private String name;
	@JsonProperty("location")
	private String location;
	@JsonProperty("customerId")
	private String customerId;

	private static final long serialVersionUID = 3160240137405631371L;

	@JsonProperty("siteID")
	public String getSiteID() {
		return siteID;
	}

	@JsonProperty("siteID")
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("customerId")
	public String getCustomerId() {
		return customerId;
	}

	@JsonProperty("customerId")
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
