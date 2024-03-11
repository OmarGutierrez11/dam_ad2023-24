package org.example.omargutierrez.cotroller;

import org.example.omargutierrez.model.Page;
import org.example.omargutierrez.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {
    @Autowired
    private PageService pageService;
    //CREACION DE NUEVAS PAGINAS
    @PostMapping
    public ResponseEntity<Page> createPage(@RequestBody Page page) {
        Page newPage = pageService.savePage(page);
        return ResponseEntity.ok(newPage);
    }
    //OBTENER INFO DE TODAS LAS PAGINAS CREADAS
    @GetMapping
    public ResponseEntity<List<Page>> getAllPages() {
        List<Page> pages = pageService.findAllPages();
        return ResponseEntity.ok(pages);
    }
    //OBTENER INFO DE UNA PAGINA EN CONCRETO POR SU ID
    @GetMapping("/{id}")
    public ResponseEntity<Page> getPageById(Long id) {
        Page page = pageService.findPageById(id);
        return ResponseEntity.ok(page);
    }
    //OBTENER INFO DE LAS PAGINAS SEGUN QUE TYPO DE PAGINA SEAN: php...
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Page>> getPagesByType(@PathVariable String type) {
        List<Page> pages = pageService.findPagesByType(type);
        return ResponseEntity.ok(pages);
    }
    //OBTENER INFO DE PAGINAS FILTRANDO POR SU NOMBRE
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Page>> getPagesByName(@PathVariable String name) {
        List<Page> pages = pageService.findPagesByName(name);
        return ResponseEntity.ok(pages);
    }
    //ACTUALIZAR PAGINA FILTRANDO POR SU ID
    @PutMapping("/{id}")
    public ResponseEntity<Page> updatePage(@PathVariable Long id, @RequestBody Page updatedPage) {
        Page page = pageService.updatePage(id, updatedPage);
        return ResponseEntity.ok(page);
    }
    //BORRADO DE PAGINA EN CONCRETO SEGUN SU ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable Long id) {
        pageService.deletePageById(id);
        return ResponseEntity.ok().build();
    }
    //BORRADO DE TODAS LAS PAGINAS ALMACENADAS
    @DeleteMapping
    public ResponseEntity<Void> deleteAllPages() {
        pageService.deleteAllPages();
        return ResponseEntity.ok().build();
    }
}
