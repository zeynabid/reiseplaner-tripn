package de.htw_berlin.tripn.repository;

import de.htw_berlin.tripn.model.PacklistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacklistRepository extends JpaRepository<PacklistItem, Long> {
    List<PacklistItem> findByTripId(Long tripId);
}
