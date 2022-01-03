package com.post_forms.rest.repository;

import com.post_forms.rest.model.FormQuestion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class FormsQuestionsRepository implements Repository<FormQuestion> {


    @PersistenceContext(unitName = "JPA")
    private EntityManager em;

    @Override
    @Transactional
    public FormQuestion create(FormQuestion formQuestion) {

        em.persist(formQuestion);
        em.flush();
        return formQuestion;
    }

    @Override
    public FormQuestion read(Integer id) {

        return em.find(FormQuestion.class, id);
    }

    public List<FormQuestion> readByFormID(Integer id) {

        Query query;
        query = em.createNamedQuery("FormQuestion.findByForm");
        query.setParameter("form", id);

        return query.getResultList();
    }


    @Override
    public FormQuestion update(FormQuestion newFormQuestion) {

        em.merge(newFormQuestion);
        em.flush();

        return newFormQuestion;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            FormQuestion formQuestion = em.find(FormQuestion.class, id);
            em.remove(formQuestion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
