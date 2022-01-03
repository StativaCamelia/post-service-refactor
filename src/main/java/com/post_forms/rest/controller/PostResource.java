package com.post_forms.rest.controller;

import com.post_forms.rest.model.Post;
import com.post_forms.rest.repository.PostsRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("post")
public class PostResource {

    @Inject
    private PostsRepository postsRepository;

    public PostResource() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAll() {

        return postsRepository.readAll();

    }

    @GET
    @Path("/{postId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getByPostId(@PathParam("postId") Integer postId) {

        return postsRepository.read(postId);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Post saveDocument(Post post) {

        return postsRepository.create(post);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDocument(@PathParam("id") int id) {

        postsRepository.delete(id);
    }

}
