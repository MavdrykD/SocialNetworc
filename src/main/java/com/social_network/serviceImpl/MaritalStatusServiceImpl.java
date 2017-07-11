package com.social_network.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.social_network.dao.MaritalStatusDao;
import com.social_network.entity.MaritalStatus;
import com.social_network.entity.Message;
import com.social_network.service.MaritalStatusService;

public class MaritalStatusServiceImpl implements MaritalStatusService{
	@Autowired
	private MaritalStatusDao maritalStatusDao;
	
	public void save(MaritalStatus maritalStatus) {
		maritalStatusDao.save(maritalStatus);
	}

	public MaritalStatus findMaritalStatus(int id) {
		return maritalStatusDao.findOne(id);
	}

	public void delete(int id) {
		maritalStatusDao.delete(id);
	}

	public void update(MaritalStatus maritalStatus) {
		maritalStatusDao.save(maritalStatus);
	}

}
