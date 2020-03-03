package com.sscodes.repository;

import com.sscodes.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Books, String> {
}
