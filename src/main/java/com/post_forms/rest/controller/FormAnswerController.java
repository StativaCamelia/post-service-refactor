package com.post_forms.rest.controller;

import com.post_forms.rest.model.FormAnswer;
import com.post_forms.rest.repository.FormAnswerRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("formAnswer")
public class FormAnswerController {

    @Inject
    private FormAnswerRepository formAnswerRepository;

    public FormAnswerController() {

    }


    @GET
    @Path("/{formAnswerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public FormAnswer getById(@PathParam("formAnswerId") Integer formAnswerId) {

        return formAnswerRepository.read(formAnswerId);
    }

    @GET
    @Path("/byFormAndUser/{formId}/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public FormAnswer getByFormIdAndUser(@PathParam("formId") Integer formId, @PathParam("userId") Integer userId) {

        return formAnswerRepository.readByQuestionAndUserId(userId, formId);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FormAnswer save(FormAnswer formAnswer) {

        return formAnswerRepository.create(formAnswer);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {

        formAnswerRepository.delete(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FormAnswer update(FormAnswer formAnswer) {

        return formAnswerRepository.update(formAnswer);
    }

}
