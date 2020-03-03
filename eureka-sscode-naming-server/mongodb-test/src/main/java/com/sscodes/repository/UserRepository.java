package com.sscodes.repository;

import com.sscodes.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ssharma6757 on 11/5/2019.
 */

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}
