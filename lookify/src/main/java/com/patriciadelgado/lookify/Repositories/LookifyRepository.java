package com.patriciadelgado.lookify.Repositories;

import java.util.List;

import com.patriciadelgado.lookify.Models.Lookify;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long> {
    
    List<Lookify> findAll();

    Long countByTitleContaining(String search);

    Long deleteByTitleStartingWith(String search);

    List<Lookify> findTop10ByOrderByCalificacionDesc();

    List<Lookify> findByArtistaContaining(String search);
}
