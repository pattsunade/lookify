package com.patriciadelgado.lookify.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.patriciadelgado.lookify.Models.Lookify;
import com.patriciadelgado.lookify.Services.LookifyServices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LookifyController {
    private final LookifyServices lookifyServices;

    public LookifyController(LookifyServices lookifyServices) {
        this.lookifyServices = lookifyServices;
    }

    @RequestMapping("/")
    public String start() {
        return "lookify/start.jsp";

    }
    @RequestMapping("/dashboard")
    public String dashboard(@Valid @ModelAttribute("lookify") Lookify lookify, Model model) {
        List<Lookify> lookifys = lookifyServices.allLookify();
        model.addAttribute("lookify", lookifys);
        return "lookify/dashboard.jsp";
    }

    @GetMapping("/lookify/add")
    public String newSong(
            @ModelAttribute("lookify") Lookify lookify) {
        return "/lookify/add.jsp";
        }
    @PostMapping("/lookify/add")
    public String create(@Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result) {
        if (result.hasErrors()) {
            return "/lookify/add.jsp";
        } else {
            lookifyServices.createLookify(lookify);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping(value="/lookify/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        lookifyServices.deleteLookify(id);
        return "redirect:/dashboard";

    }
    @RequestMapping("/lookify/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Lookify lookify = lookifyServices.findLookify(id);
        if (lookify == null) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("lookify", lookify);
            return "/lookify/show.jsp";
        }

    }
     @GetMapping("/lookify/top")
     public String topTen(Model model) {
         List<Lookify> top = lookifyServices.topTen();
         model.addAttribute("top", top);
         return "/lookify/top.jsp";
     }

     @GetMapping("/search")
     public String search(@RequestParam("busqueda") String artista, Model model){
         List<Lookify> searchArtista = lookifyServices.search(artista);
         model.addAttribute("search", searchArtista);
         model.addAttribute("busqueda", artista);
         return "/lookify/search.jsp";
     }
    
}
