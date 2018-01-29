/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.dao;

import com.it355.milankabjelic2626.model.Proizvod;
import com.it355.milankabjelic2626.model.Registracija;
import java.util.List;


public interface MilankaDao {
     void registracija(Registracija registracija);
     void dodajProizvod(Proizvod proizvod);
     void obrisiProizvod(String naziv);
     void azurirajProizvod(Proizvod proizvod);
     List <Proizvod> getProizvodi();
     Proizvod getProizvodPoNazivu(String naziv);
}
