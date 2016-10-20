package com.example;

import com.example.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    Iterable<User> findByUsername(String username);
}
