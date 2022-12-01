package com.example.supermarket.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sectors")
public class Sector {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private SectorType sectorType;
    private String floorManager;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SectorType getSectorType() {
        return sectorType;
    }

    public void setSectorType(SectorType sectorType) {
        this.sectorType = sectorType;
    }

    public String getFloorManager() {
        return floorManager;
    }

    public void setFloorManager(String floorManager) {
        this.floorManager = floorManager;
    }
}
