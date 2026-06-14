package de.htw_berlin.tripn.repository;

import de.htw_berlin.tripn.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByTripId(Long tripId);
}
