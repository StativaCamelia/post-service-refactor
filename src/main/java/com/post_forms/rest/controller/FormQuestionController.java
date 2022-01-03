package com.post_forms.rest.controller;

import com.post_forms.rest.model.FormQuestion;
import com.post_forms.rest.repository.FormsQuestionsRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("formQuestion")
public class FormQuestionController {

    @Inject
    private FormsQuestionsRepository formsQuestionsRepository;

    public FormQuestionController() {

    }


    @GET
    @Path("/{formQuestionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public FormQuestion getById(@PathParam("formQuestionId") Integer formQuestionId) {

        return formsQuestionsRepository.read(formQuestionId);
    }

    @GET
    @Path("/byForm/{formId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FormQuestion> getByPostId(@PathParam("formId") Integer formId) {

        return formsQuestionsRepository.readByFormID(formId);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FormQuestion save(FormQuestion formQuestion) {

        return formsQuestionsRepository.create(formQuestion);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {

        formsQuestionsRepository.delete(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FormQuestion update(FormQuestion formQuestion) {

        return formsQuestionsRepository.update(formQuestion);
    }

}
