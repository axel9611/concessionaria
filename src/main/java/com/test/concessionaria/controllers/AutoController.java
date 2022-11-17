package com.test.concessionaria.controllers;

import com.test.concessionaria.entities.Auto;
import com.test.concessionaria.entities.Cliente;
import com.test.concessionaria.services.AutoService;
import com.test.concessionaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    AutoService as;

    @Autowired
    ClienteService cs;

    @GetMapping("/listaAuto")
    public String getListaAuto(Model model)
    {
        model.addAttribute("auto", as.getAll());
        return "listaAuto";

    }

    @GetMapping("/aggiungiAuto")
    public String addAuto(Model model)
    {

        model.addAttribute("auto", new Auto());
        model.addAttribute("titolo", "Aggiungi auto");
        model.addAttribute("path", "aggiungiAuto/");
        return "editAuto";

    }

    @PostMapping("/aggiungiAuto")
    public String addAuto(@ModelAttribute Auto auto)
    {
        as.salva(auto);
        return "redirect:/auto/listaAuto";
    }

    @GetMapping("/modificaAuto/{id}")
    public String editAuto(@PathVariable Long id, Model model)
    {

        model.addAttribute("auto", as.getAutoById(id));
        model.addAttribute("titolo", "Modifica auto");
        model.addAttribute("path", "modificaAuto/" + id);
        return "editAuto";

    }

    @PostMapping("/modificaAuto/{id}")
    public String editAuto(@PathVariable Long id, @ModelAttribute Auto auto)
    {
        auto.setId(id);
        return addAuto(auto);
    }

    @GetMapping("/visualizzaAuto/{id}")
    public String vediAuto(@PathVariable Long id, Model model)
    {
        model.addAttribute("auto", as.getAutoById(id));
        return "visualizzaAuto";

    }

    @GetMapping("/aggiungiClienteAdAuto/{id}")
    public String aggiungiClienteAdAuto(@PathVariable Long id, Model model)
    {
        model.addAttribute("auto", as.getAutoById(id));
        model.addAttribute("clienti", cs.getAll());
        return "aggiungiClienteAdAuto";

    }

    @PostMapping("/aggiungiClienteAdAuto/{id}")
    public String aggiungiClienteAdAuto(@PathVariable Long id, String id_cliente)
    {
        Auto auto = as.getAutoById(id);
        Cliente cliente = cs.getClienteById(Long.valueOf(id_cliente));
        auto.setCliente(cliente);
        as.salva(auto);
        return "redirect:/auto/visualizzaAuto/" + id;

    }

}
