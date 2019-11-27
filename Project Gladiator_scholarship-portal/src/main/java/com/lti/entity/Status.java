package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Status {

	@Id
	@Column(name="STATUS_ID")
	private int statusId;
	
	@Column(name="STATUS_DESCRIPTION")
	private String statusDescription;
	
	public int getStatusId() {
		return statusId;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

}