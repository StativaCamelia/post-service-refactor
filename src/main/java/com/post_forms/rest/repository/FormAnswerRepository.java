package com.post_forms.rest.repository;


import com.post_forms.rest.model.FormAnswer;
import com.post_forms.rest.model.FormQuestion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class FormAnswerRepository implements Repository<FormAnswer> {

    @PersistenceContext(unitName = "JPA")
    private EntityManager em;

    @Override
    public FormAnswer create(FormAnswer formAnswer) {

        em.persist(formAnswer);
        em.flush();
        return formAnswer;
    }

    @Override
    public FormAnswer read(Integer id) {

        return em.find(FormAnswer.class, id);
    }


    public FormAnswer readByQuestionAndUserId(Integer userId, Integer questionId) {

        Query query;
        query = em.createNamedQuery("FormAnswer.findByFormQAndUser");
        query.setParameter("question", questionId);
        query.setParameter("userId", userId);

        return (FormAnswer) query.getSingleResult();
    }


    @Override
    public FormAnswer update(FormAnswer newFormAnswer) {

        em.merge(newFormAnswer);
        em.flush();

        return newFormAnswer;
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
