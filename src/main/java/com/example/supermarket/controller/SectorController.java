package com.example.supermarket.controller;

import com.example.supermarket.model.Sector;
import com.example.supermarket.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sectors")
public class SectorController {
    @Autowired
    SectorService sectorService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(sectorService.getAll());
    }

    @PostMapping
    public ResponseEntity<Sector> persist(@RequestBody Sector sector) {
        return ResponseEntity.ok(sectorService.persist(sector));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sector> getById(@PathVariable String id) {
        return ResponseEntity.ok(sectorService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sector> update(@PathVariable String id, @RequestBody Sector sector) {
        return ResponseEntity.ok(sectorService.update(id, sector));
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id) {
        sectorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
