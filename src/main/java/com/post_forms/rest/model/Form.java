package com.post_forms.rest.model;

import javax.persistence.*;

@Table(name = "forms")
@NamedQueries({
        @NamedQuery(query = "Select s from Form s where s.id = :id", name = "Forms.findById"),
        @NamedQuery(query = "Select s from Form s where s.post = :post", name = "Forms.findByPost")
})
@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "post_id", nullable = false)
    private Integer post;

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}