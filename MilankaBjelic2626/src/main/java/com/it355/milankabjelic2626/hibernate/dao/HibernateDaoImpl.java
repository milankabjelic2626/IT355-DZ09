/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.milankabjelic2626.hibernate.dao;

import com.it355.milankabjelic2626.entity.Artikal;
import com.it355.milankabjelic2626.entity.Kolekcija;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("hibernateDao")
@Service
@Transactional
public class HibernateDaoImpl implements HibernateDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<Artikal> getArtikli() {
        List<Artikal> results = (List<Artikal>) getSession().createCriteria(Artikal.class).list();
        return results;
    }

    @Override
    public Artikal getArtikalById(int id) {
        Artikal artikal = (Artikal) getSession().createCriteria(Artikal.class).add(Restrictions.eq("id", id)).uniqueResult();
        return artikal;
    }

    @Override
    public List<Kolekcija> getKolekcije() {
        List<Kolekcija> results = (List<Kolekcija>) getSession().createCriteria(Kolekcija.class).list();
        return results;
    }

    @Override
    public Kolekcija getKolekcijaById(int id) {
        Kolekcija kolekcija = (Kolekcija) getSession().createCriteria(Kolekcija.class).add(Restrictions.eq("id", id)).uniqueResult();
        return kolekcija;
    }

    @Override
    public List<Artikal> getArtikalByKolekcija(Kolekcija kolekcija) {
        return (List<Artikal>) getSession().createCriteria(Artikal.class).add(Restrictions.eq("kolekcija", kolekcija)).list();
    }

    @Override
    public void editKolekcija(Kolekcija kolekcija) {
        getSession().saveOrUpdate(kolekcija);
    }

    @Override
    public Kolekcija addKolekcija(Kolekcija kolekcija) {
        return (Kolekcija) getSession().merge(kolekcija);
    }

    @Override
    public void editArtikal(Artikal artikal) {
        getSession().saveOrUpdate(artikal);
    }

    @Override
    public Artikal addArtikal(Artikal artikal) {
        return (Artikal) getSession().merge(artikal);
    }

    @Override
    public int getCountArtikalInKolekcija(int id_kolekcije) {
        String query = "select count(*) from artikal where id_kolekcije = :id";
        Number result = (Number) getSession().createSQLQuery(query).setInteger("id", id_kolekcije).uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public int getCountArtikal() {
        Number result = (Number) getSession().createSQLQuery("select count(*) from artikal").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public void deleteArtikal(Artikal artikal) {
        getSession().delete(artikal);
    }

    @Override
    public void deleteKolekcija(Kolekcija kolekcija) {
        getSession().delete(kolekcija);
    }
    
}
