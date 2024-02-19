package com.example.omar.controller;

import com.example.omar.model.Amarre;
import com.example.omar.service.AmarreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/amarres")
public class AmarreController {
    @Autowired
    private AmarreService amarreService;
    // Otros métodos del controlador
}
