package com.ailleron.security.service;

import com.ailleron.security.domain.Ankieta;
import com.ailleron.security.repository.AnkietaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnkietaServiceImpl implements AnkietaService {

    private AnkietaRepository ankietaRepository;

    public AnkietaServiceImpl(AnkietaRepository ankietaRepository) {
        this.ankietaRepository = ankietaRepository;
    }


    @Override
    public List<Ankieta> findAll() {
        return ankietaRepository.findAll();
    }

    @Override
    public Ankieta addAnkieta(Ankieta ankieta) {
        return ankietaRepository.save(ankieta);
    }

    @Override
    public Ankieta findById(Long id) {
        Ankieta ankieta = ankietaRepository.findById(id).get();
        return ankieta;
    }
}
