package com.example.groupchat.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {

    Optional<User> findBySessionId(String sessionId);
}
