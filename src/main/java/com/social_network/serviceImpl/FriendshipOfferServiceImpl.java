package com.social_network.serviceImpl;

import com.social_network.dao.FriendshipOfferDao;
import com.social_network.entity.FriendshipOffer;
import com.social_network.entity.User;
import com.social_network.service.FriendshipOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дімон on 27.06.2017.
 */

@Service
public class FriendshipOfferServiceImpl implements FriendshipOfferService{

    @Autowired
    private FriendshipOfferDao offerDao;


    @Override
    public void save(FriendshipOffer friendshipOffer) throws Exception {
        offerDao.save(friendshipOffer);
    }

    @Override
    public List<FriendshipOffer> findAll() {
        return offerDao.findAll();
    }

    @Override
    public FriendshipOffer findOne(int id) {
        return offerDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        offerDao.delete(id);
    }

    @Override
    public void update(FriendshipOffer friendshipOffer) {
        offerDao.save(friendshipOffer);
    }

    @Override
    public List<User> findUsersByIdWhoSentTheRequest(int id) {
        List<User> users = new ArrayList<>();
        for (FriendshipOffer friendshipOffer : offerDao.findByIdWithReceivedOffers(id)){
                users.add(friendshipOffer.getUser());
        }
        return users;
    }

    @Override
    public FriendshipOffer findByIdAndSelectRequest(int user_id, int friend_id) {
        return offerDao.findByIdAndSelectRequest(user_id, friend_id);
    }


}
