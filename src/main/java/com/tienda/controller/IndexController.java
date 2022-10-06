package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.tienda.domain.Cliente;
import com.tienda.dao.ClienteDao;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller

public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model) {

       /* Cliente cliente1 = new Cliente("Juan", "Perez", "Jperez@gmail.com", "84848484");
        Cliente cliente2 = new Cliente("Pedro", "Nu", "PedNu@gmail.com", "84848484");
        Cliente cliente3 = new Cliente("Rebeca", "Alvarado", "Rebalv@gmail.com", "84848484");

        
        
        var clientes = Arrays.asList(cliente1,cliente2,cliente3); */
       var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);

        return "index";
    }

}
