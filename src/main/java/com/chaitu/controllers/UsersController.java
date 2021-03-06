package com.chaitu.controllers;

import com.chaitu.dto.appuser.AppUserDto;
import com.chaitu.services.UsersService;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/user")
public class UsersController {

    @Context UriInfo uriInfo;

    @Inject @Any
    UsersService usersService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addUser(AppUserDto appUserDto) {
        usersService.createUser(appUserDto);
        return Response
                .created(uriInfo.getRequestUri())
                .entity(appUserDto)
                .build();
    }
}
