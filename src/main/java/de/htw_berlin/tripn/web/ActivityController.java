package de.htw_berlin.tripn.web;

import de.htw_berlin.tripn.model.Activity;
import de.htw_berlin.tripn.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips/{tripId}/activities")
@CrossOrigin(origins = "*")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // GET /api/trips/1/activities
    @GetMapping
    public List<Activity> getActivities(@PathVariable Long tripId) {
        return activityService.getActivitiesByTripId(tripId);
    }

    // POST /api/trips/1/activities
    @PostMapping
    public Activity createActivity(@PathVariable Long tripId,
                                   @RequestBody Activity activity) {
        activity.setTripId(tripId);
        return activityService.createActivity(activity);
    }

    // PUT /api/trips/1/activities/1
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id,
                                                   @RequestBody Activity activity) {
        return activityService.updateActivity(id, activity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/trips/1/activities/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        if (activityService.deleteActivity(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}