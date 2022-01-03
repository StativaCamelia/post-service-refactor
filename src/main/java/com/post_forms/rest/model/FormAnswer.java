package com.post_forms.rest.model;

import javax.persistence.*;

@Table(name = "formanswer", indexes = {
        @Index(name = "question_id", columnList = "question_id")
})
@NamedQueries({
        @NamedQuery(query = "Select s from FormAnswer s where s.question = :question and s.userId = :userId", name = "FormAnswer.findByFormQAndUser")
})
@Entity
public class FormAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "question_id", nullable = false)
    private Integer question;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "content", length = 2000)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}