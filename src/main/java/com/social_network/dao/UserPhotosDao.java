package com.social_network.dao;

import com.social_network.entity.UserPhotos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Дімон on 10.07.2017.
 */
public interface UserPhotosDao extends JpaRepository<UserPhotos, Integer> {


}
