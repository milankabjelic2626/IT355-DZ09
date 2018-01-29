/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.controller;

import com.it355.milankabjelic2626.entity.Artikal;
import com.it355.milankabjelic2626.entity.Kolekcija;
import com.it355.milankabjelic2626.hibernate.dao.HibernateDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Rest {
    
    @Autowired
    HibernateDao hibernateDao;
    
    @RequestMapping(value = "/artikli", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Artikal>> getArtikli() {
        System.out.println("Ucitavanje");
        List<Artikal> artikli = hibernateDao.getArtikli();
        if (artikli.size() == 0) {
            System.out.println("Nema artikala");
            return new ResponseEntity<List<Artikal>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Artikal>>(artikli, HttpStatus.OK);
    }
    
   
    
    @RequestMapping(value = "/artikal/", method = RequestMethod.POST)
    public ResponseEntity<Void> addArtikal(@RequestBody Artikal artikal) {
        System.out.println("Dodavanje " + artikal.toString());
        hibernateDao.addArtikal(artikal);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
     @RequestMapping(value = "/artikal/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Artikal> getArtikal(@PathVariable("id") int id) {
        System.out.println("Ucitavanje artikla sa idjem:  " + id);
        Artikal artikal = hibernateDao.getArtikalById(id);
        if (artikal == null) {
            System.out.println("Artikal sa id= " + id + " nije nadjen");
            return new ResponseEntity<Artikal>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Artikal>(artikal, HttpStatus.OK);
    }
     
     @RequestMapping(value = "/artikal/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Artikal> updateArtikal(@PathVariable("id") int id, @RequestBody Artikal artikal) {
        System.out.println("Updating artikal " + id);

        artikal.setId(id);
        hibernateDao.editArtikal(artikal);
        return new ResponseEntity<Artikal>(artikal, HttpStatus.OK);
    }

    @RequestMapping(value = "/artikal/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Artikal> obrisiArtikal(@PathVariable("id") int id) {
        System.out.println("Brisanje artikla sa id= " + id);

        Artikal artikal = hibernateDao.getArtikalById(id);
        if (artikal == null) {
            System.out.println("Greska. Artikal sa id= " + id + " nije nadjen");
            return new ResponseEntity<Artikal>(HttpStatus.NOT_FOUND);
        }

        hibernateDao.deleteArtikal(artikal);
        return new ResponseEntity<Artikal>(HttpStatus.OK);
    }
     
     
    @RequestMapping(value = "/kolekcija/", method = RequestMethod.POST)
    public ResponseEntity<Void> addKolekcija(@RequestBody Kolekcija k, BindingResult res) {
        System.out.println("Dodavanje kolekcije " + k.toString());
        hibernateDao.addKolekcija(k);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
 
    }
    @RequestMapping(value = "/kolekcije", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Kolekcija>> getKolekcije() {
        System.out.println("Fetching...");
        List<Kolekcija> kolekcije = hibernateDao.getKolekcije();
        if (kolekcije.size() == 0) {
            System.out.println("Nema kolekcija");
            return new ResponseEntity<List<Kolekcija>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Kolekcija>>(kolekcije, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/kolekcija/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Kolekcija> getKolekcija(@PathVariable("id") int id) {
        System.out.println("Fetching kolekcija sa id= " + id);
        Kolekcija kolekcija = hibernateDao.getKolekcijaById(id);
        if (kolekcija == null) {
            System.out.println("Kolekcija sa id= " + id + " nije nadjena");
            return new ResponseEntity<Kolekcija>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Kolekcija>(kolekcija, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/kolekcija/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Kolekcija> updateKolekcija(@PathVariable("id") int id, @RequestBody Kolekcija kolekcija) {
        System.out.println("Updating kolekcija " + id);

        kolekcija.setId(id);
        hibernateDao.editKolekcija(kolekcija);
        return new ResponseEntity<Kolekcija>(kolekcija, HttpStatus.OK);
    }

    @RequestMapping(value = "/kolekcija/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Kolekcija> obrisiKolekciju(@PathVariable("id") int id) {
        System.out.println("Brisanje kolekcije sa id= " + id);

        Kolekcija kolekcija = hibernateDao.getKolekcijaById(id);
        if (kolekcija == null) {
            System.out.println("Kolekcija sa id= " + id + " nije nadjena");
            return new ResponseEntity<Kolekcija>(HttpStatus.NOT_FOUND);
        }

        hibernateDao.deleteKolekcija(kolekcija);
        return new ResponseEntity<Kolekcija>(HttpStatus.OK);
    }
}
