/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.dao;

import com.it355.milankabjelic2626.model.Proizvod;
import com.it355.milankabjelic2626.model.Registracija;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class MilankaDaoImpl implements MilankaDao{

    @Autowired
    DataSource dataSource;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public void registracija(Registracija registracija) {
        String sql = "INSERT INTO users VALUES(1, ?, ?, 2)";
                    jdbcTemplate.update(sql, new Object[] {registracija.getKorisnickoIme(),registracija.getLozinka()});
    }

    @Override
    public void dodajProizvod(Proizvod proizvod) {
        String sql = "INSERT INTO `proizvod`(`naziv`, `opis`, `cena`) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {proizvod.getNaziv(), proizvod.getOpis(), proizvod.getCena()});
    }

    @Override
    public void obrisiProizvod(String naziv) {
       String sql = "DELETE FROM proizvod WHERE naziv = ?";
       jdbcTemplate.update(sql, new Object[] {naziv});
    }

    @Override
    public void azurirajProizvod(Proizvod proizvod) {
        String sql = "UPDATE proizvod SET naziv = ?, opis=?, cena=?  WHERE naziv=?";
        jdbcTemplate.update(sql, new Object[] {proizvod.getNaziv(), proizvod.getOpis(), proizvod.getCena(), proizvod.getNaziv()});
    }

    @Override
    public List<Proizvod> getProizvodi() {
        return jdbcTemplate.query("select * from proizvod", new RowMapper<Proizvod>(){
            public Proizvod mapRow(ResultSet rs, int row) throws SQLException {
            Proizvod proizvod = new Proizvod();
            proizvod.setNaziv(rs.getString(2));
            proizvod.setOpis(rs.getString(3));
            proizvod.setCena(rs.getFloat(4));
            return proizvod;
            }
        });
    }
    
    @Override
    public Proizvod getProizvodPoNazivu(String naziv) {
        String sql = "SELECT * FROM proizvod WHERE naziv = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {naziv}, new BeanPropertyRowMapper<Proizvod>(Proizvod.class));
    }
    
}
