/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.service;

import com.it355.milankabjelic2626.dao.MilankaDao;
import com.it355.milankabjelic2626.model.Registracija;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistracijaServiceImpl implements RegistracijaService {

    @Autowired
    MilankaDao milankaDao;
    
    
    @Override
    public void registracija(Registracija registracija) {
       milankaDao.registracija(registracija);
    }
    
}
