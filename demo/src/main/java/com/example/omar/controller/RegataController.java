package com.example.omar.controller;

import com.example.omar.model.Regata;
import com.example.omar.service.RegataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/regatas")
public class RegataController {
    @Autowired
    private RegataService regataService;
    // Otros métodos del controlador
}
