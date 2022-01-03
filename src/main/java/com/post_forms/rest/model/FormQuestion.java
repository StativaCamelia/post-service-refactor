package com.post_forms.rest.model;

import javax.persistence.*;

@Table(name = "formquestions", indexes = {
        @Index(name = "form_id", columnList = "form_id")
})
@NamedQueries({
        @NamedQuery(query = "Select s from FormQuestion s where s.form = :form", name = "FormQuestion.findByForm")
})
@Entity
public class FormQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "form_id", nullable = false)
    private Integer form;

    @Column(name = "content", length = 2000)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}