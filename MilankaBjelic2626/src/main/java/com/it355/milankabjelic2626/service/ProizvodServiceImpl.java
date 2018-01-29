/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.service;

import com.it355.milankabjelic2626.dao.MilankaDao;
import com.it355.milankabjelic2626.model.Proizvod;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ProizvodServiceImpl implements ProizvodService{

    @Autowired
    MilankaDao milankaDao;
    
    @Override
    public void dodajProizvod(Proizvod proizvod) {
        milankaDao.dodajProizvod(proizvod);
    }

    @Override
    public void obrisiProizvod(String naziv) {
       milankaDao.obrisiProizvod(naziv);
    }

    @Override
    public void azurirajProizvod(Proizvod proizvod) {
        milankaDao.azurirajProizvod(proizvod);
    }

    @Override
    public List<Proizvod> getProizvodi() {
        return milankaDao.getProizvodi();
    }

    @Override
    public Proizvod getProizvodPoNazivu(String naziv) {
        return milankaDao.getProizvodPoNazivu(naziv);
    }
    
}
