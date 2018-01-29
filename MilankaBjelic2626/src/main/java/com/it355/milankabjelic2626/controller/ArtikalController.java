/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.controller;

import com.it355.milankabjelic2626.entity.Artikal;
import com.it355.milankabjelic2626.entity.Kolekcija;
import com.it355.milankabjelic2626.hibernate.dao.HibernateDao;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtikalController {
    
    @Autowired
    HibernateDao hibernateDao;
    
    @RequestMapping(value = "/dodajArtikal", method = RequestMethod.GET)
    public String dodajArtikal(Model model) {
        model.addAttribute("artikal", new Artikal());
        model.addAttribute("kolekcije", hibernateDao.getKolekcije());
        return "dodajArtikal";
    }

    @RequestMapping(value = "/dodajArtikal", method = RequestMethod.POST)
    public ModelAndView addProizvod(@ModelAttribute("artikal") Artikal a, ModelAndView model, BindingResult result) {
        a.setEnabled(Boolean.TRUE);
        a = hibernateDao.addArtikal(a);
        model.addObject("kolekcije", hibernateDao.getKolekcije());
        model.addObject("porukaUspesno", "Artikal je uspesno dodat/azuriran!");
        model.addObject("artikal", a);
        return model;
    }
    
     @RequestMapping(value = "/dodajKolekciju", method = RequestMethod.GET)
    public String dodajKolekciju(Model model){
        model.addAttribute("kolekcija", new Kolekcija());
        return "dodajKolekciju";
    }
    
    @RequestMapping(value = "/dodajKolekciju", method = RequestMethod.POST)
    public ModelAndView addKolekcija(@ModelAttribute("kolekcija") Kolekcija k, ModelAndView model){
        hibernateDao.addKolekcija(k);
        model.addObject("porukaUspesno", "Kolekcija je uspesno dodata/azurirana!");
        return model;
    }

    @RequestMapping(value = "/izmeniArtikal/{id}", method = RequestMethod.GET)
    public String izmeniArtikal(@PathVariable("id") int id, Model model){
        Artikal artikal = hibernateDao.getArtikalById(id);
        model.addAttribute("artikal", artikal);
        model.addAttribute("kolekcije", hibernateDao.getKolekcije());
        return "dodajArtikal";
 
   }
    
    @RequestMapping(value = "/pregledArtikala", method = RequestMethod.GET)
    public ModelAndView pregledArtikala(ModelAndView model) {
        model.addObject("artikli", hibernateDao.getArtikli());
        model.addObject("artikal", new Artikal());
        return model;
    }

    @RequestMapping(value = "/obrisiArtikal/{id}", method = RequestMethod.GET)
    public String obrisiArtikal(@PathVariable("id") int id, HttpServletRequest request) {
        System.out.println("Fetching & Deleting artikal with id " + id);
        Artikal artikal = hibernateDao.getArtikalById(id);
        if (artikal == null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        hibernateDao.deleteArtikal(artikal);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
