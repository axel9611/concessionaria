package com.test.concessionaria.controllers;

import com.test.concessionaria.entities.Auto;
import com.test.concessionaria.entities.Cliente;
import com.test.concessionaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auto")
public class ClienteController {

    @Autowired
    ClienteService cs;

    @GetMapping("/listaClienti")
    public String getListaCliente(Model model)
    {
        model.addAttribute("cliente", cs.getAll());
        return "listaCliente";

    }

    @GetMapping("/aggiungiCliente")
    public String addCliente(Model model)
    {

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("titolo", "Aggiungi cliente");
        model.addAttribute("path", "aggiungiCliente/");
        return "editCliente";

    }

    @PostMapping("/aggiungiCliente")
    public String addCliente(@ModelAttribute Cliente cliente)
    {
        cs.salva(cliente);
        return "redirect:/auto/listaClienti";
    }

    @GetMapping("/modificaCliente/{id}")
    public String editCliente(@PathVariable Long id, Model model)
    {

        model.addAttribute("cliente", cs.getClienteById(id));
        model.addAttribute("titolo", "Modifica cliente");
        model.addAttribute("path", "modificaCliente/" + id);
        return "editCliente";
    }

    @PostMapping("/modificaCliente/{id}")
    public String editCliente(@PathVariable Long id, @ModelAttribute Cliente cliente)
    {
        cliente.setId(id);
        return addCliente(cliente);
    }

    @GetMapping("/rimuoviCliente/{id}")
    public String rimuoviCliente(@PathVariable Long id)
    {

        cs.removeCliente(id);
        return "redirect:/auto/listaClienti";

    }

}
