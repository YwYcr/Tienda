package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.tienda.domain.Articulo;
import com.tienda.dao.ArticuloDao;
import com.tienda.service.ArticuloService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller

public class IndexController {
    
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {

       var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);

        return "index";
    }

}
