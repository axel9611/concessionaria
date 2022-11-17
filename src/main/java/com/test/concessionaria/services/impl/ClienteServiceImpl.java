package com.test.concessionaria.services.impl;

import com.test.concessionaria.entities.Cliente;
import com.test.concessionaria.repositories.ClienteRepository;
import com.test.concessionaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository cr;

    @Override
    public List<Cliente> getAll() {
        return cr.findAll();
    }

    @Override
    public Cliente salva(Cliente auto) {
        return cr.save(auto);
    }

    @Override
    public Cliente getClienteById(Long id) {
        return cr.findById(id).orElse(null);
    }

    @Override
    public void removeCliente(Long id) {
        cr.deleteById(id);
    }
}
