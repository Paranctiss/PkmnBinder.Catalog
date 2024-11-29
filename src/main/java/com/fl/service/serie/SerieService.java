package com.fl.service.serie;

import com.fl.model.Serie;
import com.fl.repository.serie.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository serieRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public SerieService(RestTemplate restTemplate, SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
        this.restTemplate = restTemplate;
    }

    public List<Serie> findAll(){
        return serieRepository.findAll();
    }

    public void fetchAndSaveAll() {
        List<Serie> serieList = fetch();
        serieRepository.saveAll(serieList);
    }

    private List<Serie> fetch() {

        String url = UriComponentsBuilder
                .fromUriString("https://api.tcgdex.net/v2/fr/series")
                .build()
                .toUriString();

        Serie[] seriesArray = restTemplate.getForObject(url, Serie[].class);
        assert seriesArray != null;

        //Ajoute l'extension .webp pour afficher l'image
        for (Serie serie : seriesArray) {
            if (serie.getLogo() != null && !serie.getLogo().isEmpty()) {
                serie.setLogo(serie.getLogo() + ".webp");
            }
        }
        return List.of(seriesArray);
    }



}
