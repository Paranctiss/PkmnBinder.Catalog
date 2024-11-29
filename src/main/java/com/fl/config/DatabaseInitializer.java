package com.fl.config;

import com.fl.model.Extension;
import com.fl.model.Pokemon;
import com.fl.repository.extension.FindExtensionRepository;
import com.fl.repository.pokemon.FindPokemonRepository;
import com.fl.repository.serie.SerieRepository;
import com.fl.service.Pokemon.FindPokemonService;
import com.fl.service.extension.FindExtensionService;
import com.fl.service.serie.SerieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseInitializer {

    private final SerieService serieService;
    private final FindExtensionService findExtensionService;
    private final FindPokemonService findPokemonService;
    private final FindPokemonRepository findPokemonRepository;

    public DatabaseInitializer(SerieService serieService,
                               FindExtensionService findExtensionService,
                               FindPokemonService findPokemonService,
                               FindPokemonRepository findPokemonRepository) {
        this.serieService = serieService;
        this.findExtensionService = findExtensionService;
        this.findPokemonService = findPokemonService;
        this.findPokemonRepository = findPokemonRepository;
    }

    @Bean
    public CommandLineRunner initDatabase(SerieRepository serieRepository) {
        return args -> {

            //findPokemonService.fetchAndSaveAll();
            //findExtensionService.fetchAndSaveAll();
            //serieService.fetchAndSaveAll();
            //findExtensionRepository.save(new Extension("FireExtension", "Extension pour les capacités liées au feu."));
            System.out.println("Extensions ajoutées à MongoDB.");
        };
    }
}
