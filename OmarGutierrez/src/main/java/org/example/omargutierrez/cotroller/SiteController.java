package org.example.omargutierrez.cotroller;

import org.example.omargutierrez.model.Site;
import org.example.omargutierrez.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sites")
public class SiteController {
    @Autowired
    private SiteService siteService;
    //CREACION DE UN SITE
    @PostMapping
    public ResponseEntity<Site> createSite(@RequestBody Site site) {
        Site newSite = siteService.saveSite(site);
        return ResponseEntity.ok(newSite);
    }
    //OBTENER TODOS LOS SITES
    @GetMapping
    public ResponseEntity<List<Site>> getAllSites() {
        List<Site> sites = siteService.findAllSites();
        return ResponseEntity.ok(sites);
    }
    //OBTENER SITE POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Site> getSiteById(Long id) {
        Site site = siteService.findSiteById(id);
        return ResponseEntity.ok(site);
    }
    //OBTENER SITE CON MAYOR ESPACIO QUE OTRO
    @GetMapping("/size/greater/{size}")
    public ResponseEntity<List<Site>> getSitesByTotalSizeGreaterThan(@PathVariable int size) {
        List<Site> sites = siteService.findByTotalSizeGreaterThan(size);
        return ResponseEntity.ok(sites);
    }
    //OBTENER SITE CON MENOR ESPACIO QUE OTRO
    @GetMapping("/size/less/{size}")
    public ResponseEntity<List<Site>> getSitesByTotalSizeLessThan(@PathVariable int size) {
        List<Site> sites = siteService.findByTotalSizeLessThan(size);
        return ResponseEntity.ok(sites);
    }
    //OBTENER SITE CON UN TOTAL DE ESPACIO COMPRENDIDO ENTRE 2 VALORES
    @GetMapping("/size/between/{size1}/{size2}")
    public ResponseEntity<List<Site>> getSitesByTotalSizeBetween(@PathVariable int size1, @PathVariable int size2) {
        List<Site> sites = siteService.findByTotalSizeBetween(size1, size2);
        return ResponseEntity.ok(sites);
    }
    //ACTUALIZAR SITE
    @PutMapping("/{id}")
    public ResponseEntity<Site> updateSite(@PathVariable Long id, @RequestBody Site updatedSite) {
        Site site = siteService.updateSite(id, updatedSite);
        return ResponseEntity.ok(site);
    }
    //ELIMINAR SITE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable Long id) {
        siteService.deleteSiteById(id);
        return ResponseEntity.ok().build();
    }
}
