package com.patriciadelgado.lookify.Services;

import java.util.List;
import java.util.Optional;


import com.patriciadelgado.lookify.Models.Lookify;
import com.patriciadelgado.lookify.Repositories.LookifyRepository;

import org.springframework.stereotype.Service;

@Service
public class LookifyServices {
    private final LookifyRepository lookifyRepository;

    public void deleteLookify(Long id) {
        lookifyRepository.deleteById(id);
    }

    public Lookify updateLookify(Lookify lookify) {
        return lookifyRepository.save(lookify);
    }

    public LookifyServices(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }
    //Devolviendo todos los libros.
    public List<Lookify> allLookify() {
        return lookifyRepository.findAll();
    }

    //Creando un libro.
    public Lookify createLookify(Lookify l) {
        return lookifyRepository.save(l);
    }

    //Obteniendo la información de un libro.
    public Lookify findLookify(Long id) {
        Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
        if (optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }
    }

    public List<Lookify> topTen() {
        return lookifyRepository.findTop10ByOrderByCalificacionDesc();
    }

    public List<Lookify> search(String search) {
        return lookifyRepository.findByArtistaContaining(search);
    }

    
}
