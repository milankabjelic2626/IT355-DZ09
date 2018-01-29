/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.model;

import java.io.Serializable;

public class Registracija implements Serializable{
   private static final long serialVersionUID = 1L;
    
    
    private String korisnickoIme;
    private String lozinka;

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "Registracija{" + "korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + '}';
    }
    
    
}
