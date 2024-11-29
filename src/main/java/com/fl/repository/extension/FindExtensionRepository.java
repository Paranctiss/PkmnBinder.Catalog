package com.fl.repository.extension;

import com.fl.model.Extension;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FindExtensionRepository extends MongoRepository<Extension, String> {
    Optional<Extension> findByName(String name);
}
