package com.social_network.service;

import com.social_network.entity.FriendshipOffer;
import com.social_network.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Дімон on 27.06.2017.
 */
public interface FriendshipOfferService {
    void save(FriendshipOffer friendshipOffer) throws Exception;

    List<FriendshipOffer> findAll();

    FriendshipOffer findOne(int id);

    void delete(int id);

    void update(FriendshipOffer friendshipOffer);

    List<User> findUsersByIdWhoSentTheRequest(@Param("id") int id);

    FriendshipOffer findByIdAndSelectRequest(@Param("id1") int user_id, @Param("id2") int friend_id);




}
