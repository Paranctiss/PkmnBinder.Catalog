package com.fl.controller;


import com.fl.model.Extension;
import com.fl.service.extension.FindExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/extensions")
public class ExtensionController {

    private final FindExtensionService extensionService;

    @Autowired
    public ExtensionController(FindExtensionService extensionService) {
        this.extensionService = extensionService;
    }

    @GetMapping
    public ResponseEntity<List<Extension>> getAllExtensions() {
        List<Extension> extensions = extensionService.getAllExtensions();
        return ResponseEntity.ok(extensions);
    }

    /* @GetMapping("/{name}")
    public ResponseEntity<Extension> getExtensionByName(@PathVariable String name) {
        Extension extension = extensionService.findByName(name);
        return ResponseEntity.ok(extension);
    } */

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Extension>> getExtensionByName(@PathVariable String id) {
        Optional<Extension> extension = extensionService.findById(id);
        return ResponseEntity.ok(extension);
    }


    @PostMapping
    public ResponseEntity<Extension> addExtension(@RequestBody Extension extension) {
        Extension createdExtension = extensionService.addExtension(extension);
        return ResponseEntity.ok(createdExtension);
    }


}
