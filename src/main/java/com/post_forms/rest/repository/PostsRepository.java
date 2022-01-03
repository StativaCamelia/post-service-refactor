package com.post_forms.rest.repository;

import com.post_forms.rest.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class PostsRepository implements Repository<Post> {

    @PersistenceContext(unitName = "JPA")
    private EntityManager em;

    public PostsRepository() {
    }

    @Transactional
    @Override
    public Post create(Post post) {

        em.persist(post);
        em.flush();
        return post;
    }

    @Override
    public Post read(Integer id) {

        return em.find(Post.class, id);
    }

    public List<Post> readAll() {

        Query query;
        query = em.createNamedQuery("Posts.findAll");

        return query.getResultList();
    }


    @Transactional
    public Post update(Post newPost) {

        em.merge(newPost);
        em.flush();

        return newPost;
    }


    @Transactional
    @Override
    public boolean delete(Integer id) {

        try {
            Post post = em.find(Post.class, id);
            em.remove(post);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
