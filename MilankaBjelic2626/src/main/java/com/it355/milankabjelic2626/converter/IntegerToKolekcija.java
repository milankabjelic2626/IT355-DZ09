/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.converter;

import com.it355.milankabjelic2626.entity.Kolekcija;
import com.it355.milankabjelic2626.hibernate.dao.HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
final class IntegerToKolekcija implements Converter<String, Kolekcija> {
    
    @Autowired
    HibernateDao hibernateDao;

    @Override
    public Kolekcija convert(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        System.out.println("Konvertujem u kolekciju");
        Kolekcija kol = hibernateDao.getKolekcijaById(valeu);
        return kol;
    }
}
