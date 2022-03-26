package de.iu.mtshopbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MapController {
    @GetMapping("/map")
    public ResponseEntity<String> getStores(Double lon, Double lat) {
        return ResponseEntity.of(Optional.of("TODO"));
    }
}
