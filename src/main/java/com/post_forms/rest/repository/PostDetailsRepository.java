package com.post_forms.rest.repository;

import com.post_forms.rest.model.PostDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class PostDetailsRepository implements Repository<PostDetails> {

    @PersistenceContext(unitName = "JPA")
    private EntityManager em;

    @Override
    @Transactional
    public PostDetails create(PostDetails details) {
        em.persist(details);
        em.flush();
        return details;
    }

    @Override
    @Transactional
    public PostDetails read(Integer id) {

        return em.find(PostDetails.class, id);
    }


    @Transactional
    public PostDetails update(PostDetails newPostDetails) {

        em.merge(newPostDetails);
        em.flush();

        return newPostDetails;
    }


    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
