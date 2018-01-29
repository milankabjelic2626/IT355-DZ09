/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "artikal")
public class Artikal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "naziv")
    private String naziv;
    
    @Column(name = "opis")
    private String opis;
    
    @Column(name = "cena")
    private Float cena;
    
    @Column(name = "velicina")
    private String velicina;
    
    @Column(name = "boja")
    private String boja;
    
    @Column(name = "brend")
    private String brend;
    
    @ManyToOne
    @JoinColumn(name = "id_kolekcije", referencedColumnName = "id")
    private Kolekcija kolekcija;
    
    @Column(name = "enabled")
    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public Kolekcija getKolekcija() {
        return kolekcija;
    }

    public void setKolekcija(Kolekcija kolekcija) {
        this.kolekcija = kolekcija;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Artikal{" + "id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", cena=" + cena + ", velicina=" + velicina + ", boja=" + boja + ", brend=" + brend + ", kolekcija=" + kolekcija + ", enabled=" + enabled + '}';
    }
    
    
    
}
