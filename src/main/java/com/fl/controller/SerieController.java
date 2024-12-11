package com.fl.controller;


import com.fl.model.Extension;
import com.fl.model.Serie;
import com.fl.service.extension.FindExtensionService;
import com.fl.service.serie.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public ResponseEntity<List<Serie>> getAllSeries() {
        List<Serie> series = serieService.findAll();
        return ResponseEntity.ok(series);
    }


}
