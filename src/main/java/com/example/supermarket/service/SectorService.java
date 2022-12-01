package com.example.supermarket.service;

import com.example.supermarket.model.Sector;
import com.example.supermarket.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    @Autowired
    SectorRepository sectorRepository;

    public List<Sector> getAll() {
        return sectorRepository.findAll();
    }

    public Sector persist(Sector sector) {
        return sectorRepository.save(sector);
    }

    public Sector getById(String id) {
        Optional<Sector> sectorOptional = sectorRepository.findById(id);
        if (sectorOptional.isPresent()) {
            return sectorOptional.get();
        }
        return null;
    }

    public Sector update(String id, Sector sector) {
        Optional<Sector> sectorOptional = sectorRepository.findById(id);
        if (sectorOptional.isPresent()) {
            Sector existingSector = sectorOptional.get();
            existingSector.setId(sector.getId());
            existingSector.setSectorType(sector.getSectorType());
            existingSector.setFloorManager(sector.getFloorManager());
        }
        return sectorRepository.save(sector);
    }

    public void deleteById(String id) {
        sectorRepository.deleteById(id);
    }


}
