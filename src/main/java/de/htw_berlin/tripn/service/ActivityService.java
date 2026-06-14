package de.htw_berlin.tripn.service;

import de.htw_berlin.tripn.model.Activity;
import de.htw_berlin.tripn.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getActivitiesByTripId(Long tripId) {
        return activityRepository.findByTripId(tripId);
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Optional<Activity> updateActivity(Long id, Activity updated) {
        return activityRepository.findById(id).map(a -> {
            a.setTitle(updated.getTitle());
            a.setDescription(updated.getDescription());
            a.setDateTime(updated.getDateTime());
            return activityRepository.save(a);
        });
    }

    public boolean deleteActivity(Long id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
