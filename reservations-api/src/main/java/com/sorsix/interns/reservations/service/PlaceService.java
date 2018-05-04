package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Place;
import com.sorsix.interns.reservations.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository repository;

    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    public List<Place> getPlaces() {
        return repository.findAll();
    }

    public Place savePlace(Place place){
        return repository.save(place);
    }
}
