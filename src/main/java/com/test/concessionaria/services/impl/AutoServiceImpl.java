package com.test.concessionaria.services.impl;

import com.test.concessionaria.entities.Auto;
import com.test.concessionaria.repositories.AutoRepository;
import com.test.concessionaria.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    AutoRepository ar;
    @Override
    public List<Auto> getAll() {
        return ar.findAll();
    }

    @Override
    public Auto salva(Auto auto) {
        return ar.save(auto);
    }

    @Override
    public Auto getAutoById(Long id) {
        return ar.findById(id).orElse(null);
    }
}
