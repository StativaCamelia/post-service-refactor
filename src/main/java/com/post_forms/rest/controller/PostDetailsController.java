package com.post_forms.rest.controller;

import com.post_forms.rest.model.PostDetails;
import com.post_forms.rest.repository.PostDetailsRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("postDetail")
public class PostDetailsController {

    @Inject
    private PostDetailsRepository postDetailsRepository;

    public PostDetailsController() {

    }

    @GET
    @Path("/{postDetailsId}")
    @Produces(MediaType.APPLICATION_JSON)
    public PostDetails getByPostDetailsId(@PathParam("postDetailsId") Integer postDetailsId) {

        return postDetailsRepository.read(postDetailsId);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PostDetails save(PostDetails postDetails) {

        return postDetailsRepository.create(postDetails);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PostDetails update(PostDetails postDetails) {

        return postDetailsRepository.update(postDetails);
    }
}
