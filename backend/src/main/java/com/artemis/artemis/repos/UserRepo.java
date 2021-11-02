package com.artemis.artemis.repos;

import com.artemis.artemis.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
