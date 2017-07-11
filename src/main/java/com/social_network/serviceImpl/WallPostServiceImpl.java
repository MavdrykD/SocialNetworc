package com.social_network.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social_network.dao.WallPostDao;
import com.social_network.entity.WallPosts;
import com.social_network.service.WallPostService;
@Service
public class WallPostServiceImpl implements WallPostService{
	@Autowired
	private WallPostDao wallPostDao;

	public void save(WallPosts wallPosts) {
		wallPostDao.save(wallPosts);
	}

	public List<WallPosts> findAll() {
		return wallPostDao.findAll();
	}

	public WallPosts findOne(int id) {
		return wallPostDao.findOne(id);
	}

	public void delete(int id) {
		wallPostDao.delete(id);
	}

	public void update(WallPosts wallPosts) {
		wallPostDao.save(wallPosts);
	}

}
