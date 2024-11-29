package com.fl.service.Pokemon;

import com.fl.exception.NotFoundException;
import com.fl.model.Pokemon;
import com.fl.model.Serie;
import com.fl.repository.pokemon.FindPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FindPokemonService {

    private final FindPokemonRepository findPokemonRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public FindPokemonService(FindPokemonRepository findPokemonRepository, RestTemplate restTemplate) {
        this.findPokemonRepository = findPokemonRepository;
        this.restTemplate = restTemplate;
    }

    public List<Pokemon> findAllPokemons() {
        return findPokemonRepository.findAll();
    }

    public List<Pokemon> findAllByIdSet(String idSet){
        return findPokemonRepository.findAllByIdSet(idSet);
    }

    public Pokemon findById(String id) {
        return findPokemonRepository.findById(id);
    }

    public Pokemon findByName(String name) {
        return findPokemonRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Carte " + name));
    }

    public void fetchAndSaveAll(){
        List<Pokemon> pokemonList = fetch();
        findPokemonRepository.saveAll(pokemonList);
    }

    private List<Pokemon> fetch() {
        String url = UriComponentsBuilder
                .fromUriString("https://api.tcgdex.net/v2/fr/cards")
                .build()
                .toUriString();
        Pokemon[] pokemonArray = restTemplate.getForObject(url, Pokemon[].class);
        assert pokemonArray != null;

        for(Pokemon pokemon : pokemonArray){
            pokemon.setIdSet(extractSetId(pokemon.getId()));
        }

        return List.of(pokemonArray);
    }

    private String extractSetId(String input) {
        Pattern pattern = Pattern.compile("^[^-]+");
        Matcher matcher = pattern.matcher(input);
        // Vérifier si un match a été trouvé
        if (matcher.find()) {
            return matcher.group(); // Retourne la partie avant le premier "-"
        }

        return null;
    }




}
