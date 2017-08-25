package com.social_network.dao;

import com.social_network.entity.UserPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Дімон on 10.07.2017.
 */
public interface UserPhotosDao extends JpaRepository<UserPhotos, Integer> {

    @Query("select p from UserPhotos p where p.user.id =:id")
    List<UserPhotos> findPhotosByUserId(@Param("id") int id);
}
