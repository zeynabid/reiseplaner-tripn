package de.htw_berlin.tripn.web;

import de.htw_berlin.tripn.model.PacklistItem;
import de.htw_berlin.tripn.service.PacklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips/{tripId}/packlist")
@CrossOrigin(origins = "*")
public class PacklistController {

    private final PacklistService packlistService;

    public PacklistController(PacklistService packlistService) {
        this.packlistService = packlistService;
    }

    @GetMapping
    public List<PacklistItem> getItems(@PathVariable Long tripId) {
        return packlistService.getItemsByTripId(tripId);
    }

    @PostMapping
    public PacklistItem createItem(@PathVariable Long tripId,
                                   @RequestBody PacklistItem item) {
        item.setTripId(tripId);
        return packlistService.createItem(item);
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<PacklistItem> toggleItem(@PathVariable Long id) {
        return packlistService.toggleItem(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (packlistService.deleteItem(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
