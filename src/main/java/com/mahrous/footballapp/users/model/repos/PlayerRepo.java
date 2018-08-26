package com.mahrous.footballapp.users.model.repos;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.mahrous.footballapp.users.model.entity.Player;

public interface PlayerRepo extends CrudRepository<Player, ObjectId> {
	List<Player> findByUserName(String userName);
}
