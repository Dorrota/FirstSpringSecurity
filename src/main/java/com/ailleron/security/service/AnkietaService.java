package com.ailleron.security.service;

import com.ailleron.security.domain.Ankieta;

import java.util.List;

public interface AnkietaService {

    List<Ankieta> findAll();
    Ankieta addAnkieta(Ankieta ankieta);
    Ankieta findById(Long id);
}
