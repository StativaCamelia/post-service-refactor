package com.post_forms.rest.demo;

import com.post_forms.rest.controller.FormController;
import com.post_forms.rest.controller.HelloController;
import com.post_forms.rest.controller.PostResource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("resources")
@ApplicationScoped
public class ApplicationConfig extends Application {
    /*** Do not modify addRestResourceClasses() method.* It is automatically populated with* all resources defined in the project.* If required, comment out calling this method in getClasses().*/
    private void addRestResourceClasses(Set<Class<?>> resources) {

        resources.add(HelloController.class);
        resources.add(FormController.class);
        resources.add(PostResource.class);
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}