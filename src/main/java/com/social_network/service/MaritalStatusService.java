package com.social_network.service;
import com.social_network.entity.MaritalStatus;
import com.social_network.entity.Message;

public interface MaritalStatusService {
	
	void save(MaritalStatus maritalStatus);

	MaritalStatus findMaritalStatus(int id);

	void delete(int id);

	void update(MaritalStatus maritalStatus);
}
