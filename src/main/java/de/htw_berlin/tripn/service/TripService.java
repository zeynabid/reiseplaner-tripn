package de.htw_berlin.tripn.service;

import de.htw_berlin.tripn.model.Trip;
import de.htw_berlin.tripn.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Optional<Trip> updateTrip(Long id, Trip updatedTrip) {
        return tripRepository.findById(id).map(trip -> {
            trip.setTitle(updatedTrip.getTitle());
            trip.setDestination(updatedTrip.getDestination());
            trip.setStartDate(updatedTrip.getStartDate());
            trip.setEndDate(updatedTrip.getEndDate());
            return tripRepository.save(trip);
        });
    }

    public boolean deleteTrip(Long id) {
        if (tripRepository.existsById(id)) {
            tripRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
