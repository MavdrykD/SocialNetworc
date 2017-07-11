package com.social_network.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MaritalStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maritalStatusId;	
	private String maritalStatus;
	
	@OneToMany(mappedBy = "maritalStatus")
	private List<User> list = new ArrayList<User>();
	
	public MaritalStatus() {
		
	}

	public MaritalStatus(String maritalStatus) {
		super();
		this.maritalStatus = maritalStatus;
	}

	public int getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(int maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result + maritalStatusId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaritalStatus other = (MaritalStatus) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (maritalStatusId != other.maritalStatusId)
			return false;
		return true;
	}
	
	
		
}
