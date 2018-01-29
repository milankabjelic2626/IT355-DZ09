package com.it355.milankabjelic2626.controller;

import com.it355.milankabjelic2626.model.Proizvod;
import com.it355.milankabjelic2626.service.ProizvodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProizvodController {

    @Autowired
    ProizvodService proizvodService;
    
   @RequestMapping("/proizvodForma")
   public ModelAndView prikazForme(){
   return new ModelAndView("proizvodForma", "command", new Proizvod());
   }
   
   @RequestMapping(value = "/dodajProizvod", method = RequestMethod.POST)
   public ModelAndView dodajProizvod(@ModelAttribute("proizvod") Proizvod proizvod){
       proizvodService.dodajProizvod(proizvod);
       return new ModelAndView("redirect:/pregledProizvoda");
   }
   @RequestMapping("/pregledProizvoda")
   public ModelAndView pregledProizvoda(){
       List<Proizvod> list = proizvodService.getProizvodi();
       return new ModelAndView("pregledProizvoda", "list", list);
   }
   
   @RequestMapping(value = "/izmeniProizvod/{naziv}")
   public ModelAndView edit(@PathVariable String naziv){
       Proizvod proizvod = proizvodService.getProizvodPoNazivu(naziv);
       return new ModelAndView("izmeniProizvod", "command", proizvod);
   }
   
   @RequestMapping(value = "/izmeniProizvodSave", method = RequestMethod.POST)
   public ModelAndView izmeniProizvodSave(@ModelAttribute("proizvod") Proizvod proizvod){
       proizvodService.azurirajProizvod(proizvod);
       return new ModelAndView("redirect:/pregledProizvoda");
   }
   
   @RequestMapping(value = "/obrisiProizvod/{naziv}", method = RequestMethod.GET)
   public ModelAndView obrisi(@PathVariable String naziv){
       proizvodService.obrisiProizvod(naziv);
       return new ModelAndView("redirect:/pregledProizvoda");
   }
}