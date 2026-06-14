package de.htw_berlin.tripn.web;

import de.htw_berlin.tripn.model.Trip;
import de.htw_berlin.tripn.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = "*")
public class TripController {

    private final TripService tripService;

    // Spring gibt uns den Service automatisch (Dependency Injection)
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    // GET /api/trips → alle Reisen
    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    // GET /api/trips/1 → eine Reise per ID
    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        return tripService.getTripById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/trips → neue Reise erstellen
    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    // PUT /api/trips/1 → Reise bearbeiten
    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id,
                                           @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/trips/1 → Reise löschen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        if (tripService.deleteTrip(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}