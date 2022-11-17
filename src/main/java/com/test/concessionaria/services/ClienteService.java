package com.test.concessionaria.services;

import com.test.concessionaria.entities.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getAll();

    Cliente salva(Cliente auto);

    Cliente getClienteById(Long id);

    void removeCliente(Long id);
}
