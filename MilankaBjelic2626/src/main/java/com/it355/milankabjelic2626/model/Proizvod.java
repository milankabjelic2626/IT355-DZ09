package com.it355.milankabjelic2626.model;

public class Proizvod 
{
    private String naziv;
    private String opis;
    private float cena;

    public Proizvod() {
    }

    public Proizvod(String naziv, String opis, float cena) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
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

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Proizvod{" + "naziv=" + naziv + ", opis=" + opis + ", cena=" + cena + '}';
    }

    
    
}
