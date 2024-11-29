package com.fl.repository.serie;

import com.fl.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SerieRepository extends MongoRepository<Serie, String> {

}
