package com.test.concessionaria.services;

import com.test.concessionaria.entities.Auto;

import java.util.List;

public interface AutoService {

    List<Auto> getAll();

    Auto salva(Auto auto);

    Auto getAutoById(Long id);


}
