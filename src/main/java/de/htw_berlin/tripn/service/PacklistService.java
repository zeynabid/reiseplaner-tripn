package de.htw_berlin.tripn.service;

import de.htw_berlin.tripn.model.PacklistItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PacklistService {

    private final List<PacklistItem> items = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<PacklistItem> getItemsByTripId(Long tripId) {
        return items.stream()
                .filter(i -> i.getTripId().equals(tripId))
                .toList();
    }

    public PacklistItem createItem(PacklistItem item) {
        item.setId(idCounter.getAndIncrement());
        items.add(item);
        return item;
    }

    public Optional<PacklistItem> toggleItem(Long id) {
        return items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .map(i -> {
                    i.setChecked(!i.isChecked());
                    return i;
                });
    }

    public boolean deleteItem(Long id) {
        return items.removeIf(i -> i.getId().equals(id));
    }
}
