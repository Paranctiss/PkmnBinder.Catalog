package com.fl.controller;

import com.fl.model.Extension;
import com.fl.model.Pokemon;
import com.fl.service.Pokemon.FindPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {
    private final FindPokemonService pokemonService;

    @Autowired
    public PokemonController(FindPokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllExtensions() {
        List<Pokemon> pokemons = pokemonService.findAllPokemons();
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("/{idCard}")
    public ResponseEntity<Pokemon> getById(@PathVariable String idCard) {
        Pokemon pokemon = pokemonService.findById(idCard);
        return ResponseEntity.ok(pokemon);
    }

    @GetMapping("/set/{idSet}")
    public ResponseEntity<List<Pokemon>> getAllByIdSet(@PathVariable String idSet) {
        List<Pokemon> pokemons = pokemonService.findAllByIdSet(idSet);
        return ResponseEntity.ok(pokemons);
    }

}
