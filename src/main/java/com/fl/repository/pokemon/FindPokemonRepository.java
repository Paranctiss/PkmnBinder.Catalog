package com.fl.repository.pokemon;

import com.fl.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindPokemon extends JpaRepository<Pokemon, Integer> {
    Pokemon findByName(String name);
    List<Pokemon> findByExtensionId(int id);
    List<Pokemon> findByType(String type);
}
