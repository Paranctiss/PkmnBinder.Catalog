package com.fl.repository.pokemon;

import com.fl.model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FindPokemonRepository extends MongoRepository<Pokemon, Integer> {

    Optional<Pokemon> findByName(String name);
    List<Pokemon> findAllByIdSet(String idSet);
    Pokemon findById(String id);
}
