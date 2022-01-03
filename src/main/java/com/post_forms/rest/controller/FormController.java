package com.post_forms.rest.controller;

import com.post_forms.rest.model.Form;
import com.post_forms.rest.repository.FormRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("form")
public class FormController {

    @Inject
    private FormRepository formRepository;

    public FormController() {

    }


    @GET
    @Path("/{formId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Form getById(@PathParam("formId") Integer formId) {

        return formRepository.read(formId);
    }

    @GET
    @Path("/byPost/{postId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Form getByPostId(@PathParam("postId") Integer postId) {

        return formRepository.readByPostId(postId);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Form save(Form form) {

        return formRepository.create(form);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {
        formRepository.delete(id);
    }

}
