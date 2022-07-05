package com.example.groupchat.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Integer> {

    Optional<User> findBySessionId(String sessionId);
}
