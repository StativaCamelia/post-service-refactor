package com.post_forms.rest.model;

import javax.persistence.*;

@Table(name = "posts")
@NamedQueries({
        @NamedQuery(query = "Select s from Post s", name = "Posts.findAll")
})
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Lob
    @Column(name = "status")
    private String status;

    @Column(name = "has_form", nullable = false)
    private Boolean hasForm = false;

    public Boolean getHasForm() {
        return hasForm;
    }

    public void setHasForm(Boolean hasForm) {
        this.hasForm = hasForm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}