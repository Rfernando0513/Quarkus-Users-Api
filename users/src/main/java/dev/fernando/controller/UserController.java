package dev.fernando.controller;

import dev.fernando.entity.UserEntity;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import dev.fernando.service.UserService;

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class UserController {

    @Inject
    private UserService _userService;

    public UserController(UserService userService) {
        this._userService = userService;
    }


    @POST
    @Transactional
    public Response createUsers(UserEntity userEntity) {
        try{
            _userService.createUser(userEntity);
            return Response.ok(userEntity).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao criar usuario: " + e.getMessage()).build();
        }

    }
}
