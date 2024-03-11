package org.example.omargutierrez.service;


import org.example.omargutierrez.model.Site;
import org.example.omargutierrez.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;
    //GUARDAR SITE
    public Site saveSite(Site site) {

        return siteRepository.save(site);
    }
    //ENCONTRAR POR ID
    public Site findSiteById(Long id) {
        return siteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Site no encontrado con ID: " + id));
    }
    //BUSCAR TODOS LOS SITES
    public List<Site> findAllSites() {
        return siteRepository.findAll();
    }
    //ACTUALZIAR UN SITE POR SU ID
    public Site updateSite(Long id, Site updatedSite) {
        Site existingSite = findSiteById(id);
        existingSite.setDescription(updatedSite.getDescription());
        existingSite.setUrl(updatedSite.getUrl());
        return siteRepository.save(existingSite);
    }
    //BORRAR SITE POR SU ID
    public void deleteSiteById(Long id) {
        Site site = findSiteById(id);
        siteRepository.delete(site);
    }
    //ENCONTRAR CON ESPACIO TOTAL MAYOR QUE UN ESPACIO
    public List<Site> findByTotalSizeGreaterThan(int size) {
        return siteRepository.findByTotalsizeGreaterThan(size);
    }
    //ENCONTRAR CON ESPACIO TOTAL MENOR QUE UN ESPACIO
    public List<Site> findByTotalSizeLessThan(int size) {
        return siteRepository.findByTotalsizeLessThan(size);
    }
    //ENCONTRAR CON ESPACIO TOTAL COMPRENDIDO ENTRE 2 ESPACIOS
    public List<Site> findByTotalSizeBetween(int size1, int size2) {
        return siteRepository.findByTotalsizeBetween(size1, size2);
    }


}
