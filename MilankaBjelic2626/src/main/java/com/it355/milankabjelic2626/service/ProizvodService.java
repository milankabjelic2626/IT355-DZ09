/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.service;

import com.it355.milankabjelic2626.model.Proizvod;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public interface ProizvodService {
     void dodajProizvod(Proizvod proizvod);
     void obrisiProizvod(String naziv);
     void azurirajProizvod(Proizvod proizvod);
     List <Proizvod> getProizvodi();
     Proizvod getProizvodPoNazivu(String naziv);
}
