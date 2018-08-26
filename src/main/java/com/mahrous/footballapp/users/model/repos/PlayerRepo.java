package com.mahrous.footballapp.users.model.repos;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.mahrous.footballapp.users.model.entity.Player;

public interface PlayerRepo extends CrudRepository<Player, ObjectId> {
    Optional<Player> findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByUserNameOrEmail(String userName, String email);

    boolean existsByEmail(String email);
}
