package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Place;
import com.bezkoder.spring.login.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/spot", produces = "application/json;charset=UTF-8")
public class PlacesController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping(value = "/places", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Place>> getPlaces() {
        List<Place> places = placeRepository.findAll();
        return ResponseEntity.ok(places);
    }
    @PostMapping(value = "/addplace", produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> addPlace(@RequestBody Place place) {
        Place newPlace = new Place(place.getName(), place.getLatitude(), place.getLongitude(), place.getCategory());
        placeRepository.save(newPlace);
        return ResponseEntity.ok("Place added successfully!");
    }
}
