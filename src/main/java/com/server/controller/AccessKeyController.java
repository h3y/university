package com.server.controller;

import com.server.dao.AccessKey1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Slavik Glodan on 19.12.2016.
 */
@Path("users")
public class AccessKeyController {
    @GET
    @Path("/accesskey")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccessKey() {
        new AccessKey1().getAccessKey("123");
       return "";
    }
}
