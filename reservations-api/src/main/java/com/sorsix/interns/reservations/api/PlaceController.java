package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Place;
import com.sorsix.interns.reservations.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }

    @PostMapping
    public Place savePlace(@RequestBody Place place){
        return placeService.savePlace(place);
    }
}
