package de.htw_berlin.tripn.service;

import de.htw_berlin.tripn.model.PacklistItem;
import de.htw_berlin.tripn.repository.PacklistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacklistService {

    private final PacklistRepository packlistRepository;

    public PacklistService(PacklistRepository packlistRepository) {
        this.packlistRepository = packlistRepository;
    }

    public List<PacklistItem> getItemsByTripId(Long tripId) {
        return packlistRepository.findByTripId(tripId);
    }

    public PacklistItem createItem(PacklistItem item) {
        return packlistRepository.save(item);
    }

    public Optional<PacklistItem> toggleItem(Long id) {
        return packlistRepository.findById(id).map(i -> {
            i.setChecked(!i.isChecked());
            return packlistRepository.save(i);
        });
    }

    public boolean deleteItem(Long id) {
        if (packlistRepository.existsById(id)) {
            packlistRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
