package com.post_forms.rest.repository;

import com.post_forms.rest.model.Form;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


public class FormRepository implements Repository<Form> {

    @PersistenceContext(unitName = "JPA")
    private EntityManager em;

    @Transactional
    @Override
    public Form create(Form form) {

        em.persist(form);
        em.flush();
        return form;
    }

    @Transactional
    @Override
    public Form read(Integer id) {

        Query query;
        query = em.createNamedQuery("Forms.findById");
        query.setParameter("id", id);

        return (Form) query.getSingleResult();

    }

    @Transactional
    public Form readByPostId(Integer postId) {

        Query query;
        query = em.createNamedQuery("Forms.findByPost");
        query.setParameter("post", postId);

        return (Form) query.getSingleResult();

    }

    @Override
    public Form update(Form newObject) {

        return null;
    }


    @Transactional
    @Override
    public boolean delete(Integer id) {

        try {
            Form form = em.find(Form.class, id);
            em.remove(form);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
