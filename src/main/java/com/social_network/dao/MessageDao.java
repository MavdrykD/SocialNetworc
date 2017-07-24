package com.social_network.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.jpa.JpaVendorAdapter;

import com.social_network.entity.Message;

import java.util.List;

public interface MessageDao extends JpaRepository<Message, Integer>{

    //знаходить всі переписки залогованого юзера
    @Query("select m from Message m where m.userSender.id =:id or m.userReceiver.id =:id")
    List<Message> findAllDialogue(@Param("id") int id);

    //знаходить всі переписки залогованого юзера для попереднього перегладу
    @Query("select m from Message m where (m.userSender.id =:id or m.userReceiver =:id) and m.forPreview = true")
    List<Message> findAllMessagesForPreview(@Param("id")int id);

	//знаходить остатнє повідомлення з переписки між двома користувачами(id потрібно буде міняти місцями)
    @Query ("select m from Message m where m.userSender.id =:idSender and m.userReceiver.id =:idReceiver and m.forPreview = true")
    Message findLastDialogue(@Param("idSender") int idSender, @Param("idReceiver") int idReceiver);

    //знаходить весь діалог між двома юзерами
    @Query("select m from Message m where (m.userReceiver.id =:idReceiver and m.userSender.id =:idSender) or (m.userReceiver.id =:idSender and m.userSender.id =:idReceiver)")
    List<Message> findOneDialogue(@Param("idSender") int idSender, @Param("idReceiver") int idReceiver);

}
