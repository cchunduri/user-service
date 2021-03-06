package com.chaitu.exceptions.handlers;

import com.chaitu.dto.AppErrors;
import com.chaitu.dto.ErrorMessage;
import com.chaitu.exceptions.users.UserAlreadyExistsException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.List;

import static javax.ws.rs.core.Response.Status.CONFLICT;

@Provider
public class UserServiceExceptionsService implements ExceptionMapper<UserAlreadyExistsException> {

    @Override
    public Response toResponse(UserAlreadyExistsException exception) {
        return Response
                .status(CONFLICT)
                .entity(getErrorEntity(exception))
                .build();
    }

    private AppErrors getErrorEntity(UserAlreadyExistsException exception) {
        return new AppErrors(List.of(exception.getMessage()));
    }
}
