package com.fl.service.extension;

import com.fl.exception.NotFoundException;
import com.fl.model.Extension;
import com.fl.model.Serie;
import com.fl.repository.extension.FindExtensionRepository;
import com.fl.repository.serie.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindExtensionService {
    private final FindExtensionRepository findExtensionRepository;
    private final SerieRepository serieRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public FindExtensionService(
            FindExtensionRepository findExtensionRepository,
            RestTemplate restTemplate,
            SerieRepository serieRepository
    ) {
        this.findExtensionRepository = findExtensionRepository;
        this.restTemplate = restTemplate;
        this.serieRepository = serieRepository;
    }

    public Extension findByName(String name) {
        return findExtensionRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Extension " + name));
    }

    public Extension addExtension(Extension extension) {
        return findExtensionRepository.save(extension);
    }

    public List<Extension> getAllExtensions() {
        return findExtensionRepository.findAll();
    }

    public void fetchAndSaveAll(){
        List<Serie> series = serieRepository.findAll();
        List<Extension> extensions = new ArrayList<>();
        for(Serie serie: series){
            ApiResponse apiResponse = fetchAll(serie.getId());
            List<Extension> extensionsList = mapApiResponse(apiResponse);
            extensions.addAll(extensionsList);
        }
        findExtensionRepository.saveAll(extensions);


    }

    private ApiResponse fetchAll(String idSerie){
        System.out.println("https://api.tcgdex.net/v2/fr/series/{idSerie}");
        String url = UriComponentsBuilder
                .fromUriString("https://api.tcgdex.net/v2/fr/series/{idSerie}")
                .buildAndExpand(idSerie)
                .toUriString();

        ApiResponse apiResponse = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<ApiResponse>() {}).getBody();
        assert apiResponse != null;

        return apiResponse;
    }

    private List<Extension> mapApiResponse(ApiResponse apiResponse) {
        List<Extension> extensions = new ArrayList<>();
        System.out.println(apiResponse);
        if (apiResponse != null && apiResponse.getSets() != null) {
            for (Set set : apiResponse.getSets()) {
                extensions.add(new Extension(
                        set.getId(),
                        apiResponse.getId(),
                        set.getName(),
                        set.getLogo()+".webp",
                        set.getSymbol()+".webp",
                        set.getCardCount().getTotal()
                ));
            }
        }
        return extensions;
    }


    private static class ApiResponse {
        private String id;
        private List<Set> sets;

        // Getters et Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public List<Set> getSets() { return sets; }
        public void setSets(List<Set> sets) { this.sets = sets; }
    }

    // Classe Set pour mapper les données de chaque set
    private static class Set {
        private String id;
        private String name;
        private String logo;
        private String symbol;
        private CardCount cardCount;

        // Getters et Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getLogo() { return logo; }
        public void setLogo(String logo) { this.logo = logo; }

        public String getSymbol() { return symbol; }
        public void setSymbol(String symbol) { this.symbol = symbol; }

        public CardCount getCardCount() { return cardCount; }
        public void setCardCount(CardCount cardCount) { this.cardCount = cardCount; }
    }

    // Classe CardCount pour mapper cardCount.total
    private static class CardCount {
        private int official;
        private int total;

        // Getters et Setters
        public int getOfficial() { return official; }
        public void setOfficial(int official) { this.official = official; }

        public int getTotal() { return total; }
        public void setTotal(int total) { this.total = total; }
    }

}
