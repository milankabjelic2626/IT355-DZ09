/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.hibernate.dao;

import com.it355.milankabjelic2626.entity.Artikal;
import com.it355.milankabjelic2626.entity.Kolekcija;
import java.util.List;


public interface HibernateDao {
    public List<Artikal> getArtikli();
    public Artikal getArtikalById(int id);
    public List<Kolekcija> getKolekcije();
    public Kolekcija getKolekcijaById(int id);
    public List<Artikal> getArtikalByKolekcija(Kolekcija kolekcija);
    public void editKolekcija(Kolekcija kolekcija);
    public Kolekcija addKolekcija(Kolekcija kolekcija);
    public void editArtikal(Artikal artikal);
    public Artikal addArtikal(Artikal artikal);
    public int getCountArtikalInKolekcija(int id_kolekcije);
    public int getCountArtikal();
    public void deleteArtikal(Artikal artikal);
    public void deleteKolekcija(Kolekcija kolekcija);
}
