package com.patriciadelgado.lookify.Controllers;

import java.util.List;

import com.patriciadelgado.lookify.Models.Lookify;
import com.patriciadelgado.lookify.Services.LookifyServices;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LookifyApi {
    private final LookifyServices lookifyServices;

    public LookifyApi(LookifyServices lookifyServices) {
        this.lookifyServices = lookifyServices;
    }
    @RequestMapping("/api/lookify")
    public List<Lookify> start() {
        return lookifyServices.allLookify();
    }

    @RequestMapping(value = "/api/lookify", method= RequestMethod.POST)
    public Lookify create(
        @RequestParam(value = "title") String title,
        @RequestParam(value = "artista") String artista,
            @RequestParam(value = "calificacion") Integer calificacion) {
        Lookify lookify = new Lookify(title, artista, calificacion);
        return lookifyServices.createLookify(lookify);
    }
    @RequestMapping(value = "/api/lookify/{id}")
    public Lookify show(@PathVariable("id") Long id) {
        Lookify lookify = lookifyServices.findLookify(id);
        return lookify;
    }
    @RequestMapping(value = "/api/lookify/{id}", method = RequestMethod.PUT)
    public Lookify update(@PathVariable("id") Long id,
    @RequestParam(value = "title") String title,
    @RequestParam(value = "artista") String artista,
            @RequestParam(value = "calificacion") Integer calificacion) {
        Lookify lookify = lookifyServices.findLookify(id);
        lookify.setTitle(title);
        lookify.setArtista(artista);
        lookify.setCalificacion(calificacion);

        return lookifyServices.updateLookify(lookify);
    }

    @RequestMapping(value = "/api/lookify/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        lookifyServices.deleteLookify(id);
    }
    
}
