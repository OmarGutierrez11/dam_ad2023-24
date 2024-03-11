package org.example.omargutierrez.service;

import org.example.omargutierrez.model.Page;
import org.example.omargutierrez.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {
    @Autowired
    private PageRepository pageRepository;

    //GUARDADO DE PAGINA
    public Page savePage(Page page) {

        return pageRepository.save(page);
    }
    //BUSQUEDA DE PAGINA POR ID
    public Page findPageById(Long id) {
        return pageRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Page no encontrado con ID: " + id));
    }
    //BUSQUEDA DE INFO DE TODAS LAS PAGINAS
    public List<Page> findAllPages() {
        return pageRepository.findAll();
    }
    //ACTUALIZACION DE INFO DE UNA PAGINA POR SU ID
    public Page updatePage(Long id, Page updatedPage) {
        Page existingPage = findPageById(id);
        existingPage.setName(updatedPage.getName());
        existingPage.setType(updatedPage.getType());
        return pageRepository.save(existingPage);
    }
    //BORRADO DE PAGINA EN CONCRETO POR SU ID
    public void deletePageById(Long id) {
        Page page = findPageById(id);
        pageRepository.delete(page);
    }
    //BORRADO DE TODAS LAS PAGINAS ALMACENADAS
    public void deleteAllPages() {
        pageRepository.deleteAll();
    }
    //BUSCAR PAGINAS POR TIPO DE PAGINAS
    public List<Page> findPagesByType(String type) {
        return pageRepository.findByType(type);
    }
    //BUSCAR PAGINA POR NOMBRE DE PAGINA
    public List<Page> findPagesByName(String name) {
        return pageRepository.findByName(name);
    }

}
