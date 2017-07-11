package com.social_network.dao;

import com.social_network.entity.FriendshipOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Дімон on 27.06.2017.
 */
public interface FriendshipOfferDao extends JpaRepository<FriendshipOffer, Integer> {

    // знаходить всіх користувачів, які прислали запит зологованому юзеру і ще непідтвердженні
    @Query("select f from FriendshipOffer f where f.friend.id =:id and f.acceptTheOffer = false")
    List<FriendshipOffer> findByIdWithReceivedOffers(@Param("id") int id);

    //знаходить шукану стрічку в якій ми хочемо змінити поле acceptTheOffer
    @Query("select f from FriendshipOffer f where f.user.id =:id1 and f.friend.id =:id2")
    FriendshipOffer findByIdAndSelectRequest(@Param("id1") int user_id, @Param("id2") int friend_id);

    //знаходить всіх юзерів, кому надіслав запрошення залогований юзер
    @Query("select f from FriendshipOffer  f where f.user.id =:id")
    List<FriendshipOffer> findAllUsersByIdToWhomISentTheRequest(@Param("id") int id);

    //знаходить всіх юзерів, хто надіслав запрошення залогованому юзеру
    @Query("select f from FriendshipOffer f where f.friend.id =:id")
    List<FriendshipOffer> findAllUsersByIdWhoSentMeARequest(@Param("id") int id);

}
