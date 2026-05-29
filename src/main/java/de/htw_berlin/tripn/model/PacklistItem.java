package de.htw_berlin.tripn.model;

public class PacklistItem {

    private Long id;
    private Long tripId;
    private String name;
    private boolean checked;

    public PacklistItem() {}

    public PacklistItem(Long id, Long tripId, String name, boolean checked) {
        this.id = id;
        this.tripId = tripId;
        this.name = name;
        this.checked = checked;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTripId() { return tripId; }
    public void setTripId(Long tripId) { this.tripId = tripId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }
}
